import java.lang.reflect.Array;
import java.util.Arrays;

public class tEST1 {
    public static void main(String[] args) {
        int i=1;
        for(int j=0;j<31;++j){
            String a= Integer.toString(i);
            char[] temp=a.toCharArray();
            Arrays.sort(temp);
            System.out.print("\""+new String(temp)+"\""+",");
            i*=2;
        }
    }
}
