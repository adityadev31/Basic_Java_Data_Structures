import java.lang.Math;

public class Main{
    
    public static int findSQSum(int n){
        int storage[] = new int[n+1];
        storage[1] = 1;
        for(int i=2; i<=n; i++){
            int min=0;
            int x = (int)Math.sqrt(i);      // for perfect squares
            if(x*x==i){storage[i] = 1;}
            else                            // for non perfect ones
                storage[i] = storage[i-1] + storage[1];
        }return storage[n];
    }
    
    public static void main(String[] args){
        System.out.println(findSQSum(10));
    }
}
