import java.util.*;

public class Main {
    
    public static int solve(int[] coins, int target, int n, int[][] store){
        if(target==0) return store[n][target] = 1;
        if(n==0) return store[n][target] = 0;
        if(store[n][target]!=-1) return store[n][target];
        if(coins[n-1]>target){              // current coin is > target = skip (n-1)
            if(store[n-1][target]!=-1) return store[n][target] = store[n-1][target];
            else{
                store[n-1][target] = solve(coins, target, n-1, store);
                return store[n][target] = store[n-1][target];
            }
        }
        else{
            int op1, op2;
            if(store[n-1][target]!=-1) op1 = store[n-1][target];    // skip -> n-1
            else{
                store[n-1][target] = solve(coins, target, n-1, store);
                op1 = store[n-1][target];
            }
            if(store[n][target-coins[n-1]]!=-1) op2 = store[n][target-coins[n-1]];  // selected -> n
            else{
                store[n][target-coins[n-1]] = solve(coins, target-coins[n-1], n, store);
                op2 = store[n][target-coins[n-1]];
            }
            store[n][target] = op1 + op2;
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

// ans = 5
