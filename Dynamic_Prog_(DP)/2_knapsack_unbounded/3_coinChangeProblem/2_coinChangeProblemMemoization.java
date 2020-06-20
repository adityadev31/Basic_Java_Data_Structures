import java.util.*;

public class Main {
    
    public static int solve(int[] coins, int target, int n, int[][] store){
        if(target==0) return store[n][target] = 1;
        if(n==0) return store[n][target] = 0;
        if(store[n][target]!=-1) return store[n][target];
        if(coins[n-1]>target) return store[n-1][target] = solve(coins, target, n-1, store);   // skip
        else{
            int op1, op2;
            op1 = solve(coins, target, n-1, store);            // skip
            op2 = solve(coins, target-coins[n-1], n, store);   // selected
            store[n][target] = op1 + op2;                      // both
        }
        return store[n][target];
    }
    
    public static int solve(int[] coins, int target, int n){
        int[][] store = new int[n+1][target+1];
        Arrays.stream(store).forEach(a->Arrays.fill(a,-1));
        return solve(coins, target, n, store);
    }
    
    public static void main(String[] args) throws Exception {
        int coins[] = {1,2,3};
        int target = 5;
        System.out.println(solve(coins, target, coins.length));
    }
}

// ans  = 5
