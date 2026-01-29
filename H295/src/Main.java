import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        //TIP 当文本光标位于高亮显示的文本处时按 <shortcut actionId="ShowIntentionActions"/>
        // 查看 IntelliJ IDEA 建议如何修正。
        System.out.println("Hello and welcome!");

        int[] test={1,5,6,4,2,3,7,-1};
//        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
//        for (int j : test) {
//            pq.add(j);
//            System.out.println(pq.peek());
//        }
        MedianFinder m=new MedianFinder();
        int l=1;
        for(int num:test){
            m.addNum(num);
            System.out.println(m.findMedian()+"**********"+median(test,l));
            ++l;
        }
    }

    private static double median(int[] nums, int l){
        int[] temp=new int[l];
        for(int i=0;i<l;++i){
            temp[i]=nums[i];
        }
        Arrays.sort(temp);
        int m=temp[l/2];
        if(l%2==1)return m;
        return (m+temp[l/2-1])/2.0;
    }
}