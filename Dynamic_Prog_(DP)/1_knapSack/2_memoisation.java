import java.util.*;

public class Main {
    
    public static int knapSack(int wts[], int vals[], int wtlt, int n, int store[][]){
        if(n==0 || wtlt<=0){ return 0; }                                                     // base case
        if(store[n][wtlt]!=-1){ return store[n][wtlt]; }                                     // already present
        if(wts[n-1]>wtlt){ return store[n][wtlt] = knapSack(wts, vals, wtlt, n-1, store); }  // current item's weight exceeding the limit of bag(not including)
        int op1 = vals[n-1] + knapSack(wts, vals, wtlt-wts[n-1], n-1, store);                // including current item
        int op2 = knapSack(wts, vals, wtlt, n-1, store);                                     // not including current item
        int max = op1>op2 ? op1:op2;
        store[n][wtlt] = max;
        return store[n][wtlt];
    }
    
    public static int knapSack(int wts[], int vals[], int wtlt, int n){
        int[][] store = new int[n+1][wtlt+1];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=wtlt; j++){
                store[i][j] = -1;
            }
        }
        return knapSack(wts, vals, wtlt, n, store);
    }
    
    public static void main(String[] args) throws Exception {
        int wts[] = {10, 20, 30};
        int vals[] = {60, 100, 120};
        int wtlt = 50;                                                 // bag limit for weights
        System.out.print("Max profit = " + knapSack(wts, vals, wtlt, wts.length));
    }
}


// ans = 220
