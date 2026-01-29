import java.util.LinkedList;
import java.util.Queue;

class Solution {
        public double soupServings(int n) {
            double ans=0;
            if(n%25>0){
                n=n/25+1;
            }else{
                n/=25;
            }
            Queue<positionProability> dp=new LinkedList<>();
            dp.add(new positionProability(n,n,1));
            while(!dp.isEmpty()){
                positionProability temp=dp.remove();
                if(temp.x==0&&temp.y==0){
                    ans+=0.5* temp.p;
                    continue;
                }
                if(temp.x==0){
                    ans+= temp.p;
                    continue;
                }
                if(temp.y==0){
                    continue;
                }
                for(int i=1;i<=4;++i){
                    int l=Math.max(0,temp.x-i);
                    int r=Math.max(0, temp.y+i-4);
                    dp.add(new positionProability(l,r,0.25* temp.p));
                }
            }
            return ans;
        }
    }

