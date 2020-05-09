import java.util.*;

public class Main {
    
    
    public static int knapsack(int[] wts, int[] vals, int leftSpace, int n, int[][] store){
        for(int i=1; i<=n; i++){                  // in loop (n=i) (leftSpace=j)
            for(int j=1; j<=leftSpace; j++){
                if(wts[i-1]<=j){
                    int op1 = vals[i-1] + store[i-1][j-wts[i-1]];  // selection
                    int op2 = store[i-1][j];                       // no selection
                    int max = op1>op2?op1:op2;
                    store[i][j] = max;
                }
                else
                    store[i][j] = store[i-1][j];                   // no selection
            }
        }
        return store[n][leftSpace];
    }
    
    public static int knapsack(int[] wts, int[] vals, int leftSpace, int n){
        int[][] store = new int[n+1][leftSpace+1];
        // initialization (base case)
        for(int i=0; i<=n; i++){
            for(int j=0; j<=leftSpace; j++){
                if(i==0 || j==0)
                    store[i][j] = 0;
            }
        }
        return knapsack(wts, vals, leftSpace, n, store);
    }
    
    public static void main(String[] args) throws Exception {
        int wts[] = {10, 20, 30};
        int vals[] = {60, 100, 120};
        int leftSpace = 50; 
        System.out.print("Max profit = " + knapsack(wts, vals, leftSpace, wts.length));
    }
}

// ans 220
