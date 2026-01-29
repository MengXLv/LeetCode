public class diufantu {
    public void col(int n){
        for(int i=1;5*i<=n;++i){
            for(int j=1;4*j<=n;++j){
                if(5*i+4*j==n&&(i%5==0||i%4==0)&&(j%4==0||j%5==0)){
                    System.out.println(i+"---"+j);
                }
            }
        }
    }
}
