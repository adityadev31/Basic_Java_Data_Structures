import java.util.*;

public class Main {
    
    public static int sol(int n, int[] store){
        if(n == 0 || n == 1) return n;
        int min = Integer.MAX_VALUE;
        for(int j=1; j*j<=n; j++){
            int memo = -1;
            if(store[n-j*j]!=Integer.MAX_VALUE) memo = store[n-j*j];  // memoization
            else memo = sol(n-j*j);                                   // recursive call
            min = Math.min(min, memo+1);
        }
        return store[n]=min;      // storing ans values in store[]
    }
    
    public static int sol(int n){
        int[] store = new int[n+1];
        Arrays.fill(store, Integer.MAX_VALUE);
        return sol(n, store);
    }
   
    
    public static void main(String[] args) throws Exception {
        int n = 8;
        int ans = sol(n);
        System.out.println(ans);
    }
}


// n=9 --> 1, n=8 --> 2
