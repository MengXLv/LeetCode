import java.util.*;

public class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] answer = new int[n - k + 1];
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < k; ++i) {
            count.merge(nums[i], 1, Integer::sum);
        }
        for(int i=k;i<n;++i){
            count.merge(nums[i], 1, Integer::sum);
            if(count.size()<=x){
                for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
                    answer[i-k] += entry.getKey()*entry.getValue();
                }
            }else{
                List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(count.entrySet());
                entryList.sort((entry1, entry2) -> {
                    int valueCompare = entry2.getValue().compareTo(entry1.getValue());
                    if (valueCompare != 0) {
                        return valueCompare;
                    }
                    return entry2.getKey().compareTo(entry1.getKey());
                });

                for(int j=0;j<x;++j){
                    Map.Entry<Integer, Integer> entry = entryList.get(j);
                    answer[i-k]+=(entry.getKey()*entry.getValue());
                }
            }
            count.merge(nums[i-k],-1,Integer::sum);
            if(count.getOrDefault(nums[i-k],0)==0){
                count.remove(nums[i-k]);
            }
        }
        return answer;
    }
}
