import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 0);
            }
            map.put(num, map.get(num) + 1);
        }
        int n = map.size();
        int[][] cnt = new int[2][n];
        int i = 0;
        for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
            cnt[0][i] = entry.getValue();
            cnt[1][i] = entry.getKey();
            ++i;
        }
        int[] ans=new int[k];
        i=0;
        buildHeap(cnt,n-1);
        while(i<k){
            ans[i]=cnt[1][0];
            swap(cnt,0,n-1-i);
            heapify(cnt,0,n-2-i);
            ++i;
        }
        return ans;
    }
    private void buildHeap(int[][] cnt,int len){
        for(int i=(len-1)/2;i>=0;--i){
            heapify(cnt,i,len);
        }
    }

    private void heapify(int[][] cnt,int cur,int end){
        int son=2*cur+1;
        int max=cur;
        if(son<=end&&cnt[0][max]<cnt[0][son]){
            max=son;
        }
        ++son;
        if(son<=end&&cnt[0][max]<cnt[0][son]){
            max=son;
        }
        if(max!=cur){
            swap(cnt,cur,max);
            heapify(cnt,max,end);
        }
    }

    private void swap(int[][] cnt,int x,int y){
        if(x==y)return;
        int temp=cnt[0][x];
        cnt[0][x]=cnt[0][y];
        cnt[0][y]=temp;
        temp=cnt[1][x];
        cnt[1][x]=cnt[1][y];
        cnt[1][y]=temp;
    }
}
