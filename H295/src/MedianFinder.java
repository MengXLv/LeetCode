import java.util.PriorityQueue;

public class MedianFinder {
    int total=0;
    PriorityQueue<Integer> L=new PriorityQueue<>((a,b)-> b-a);
    PriorityQueue<Integer> R=new PriorityQueue<>();
    public MedianFinder() {

    }

    public void addNum(int num) {
        ++total;
        int lSize=L.size();
        int rSize=R.size();
        if(lSize==0){
            L.add(num);
            return;
        }
        int l=L.peek();
        if(num<=l){
            if(lSize==rSize+1){
                L.poll();
                R.add(l);
            }
            L.add(num);
        }else{
            if(rSize==0){
                R.add(num);
            }else{
                int r=R.peek();
                if(num<r){
                    if(lSize==rSize){
                        L.add(num);
                    }else{
                        R.add(num);
                    }
                }else{
                    if(lSize==rSize){
                        L.add(r);
                        R.poll();
                    }
                    R.add(num);
                }
            }
        }
    }

    public double findMedian() {
        double l=L.peek();
        //System.out.println(lSize+"---"+rSize);
        if(total%2==1)
            return l*1.0;
        return (l+R.peek())/2.0;
    }
}
