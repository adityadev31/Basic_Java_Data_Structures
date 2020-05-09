import java.util.*;

public class Main {
    
    
    public static int knapSack(int wts[], int vals[], int wtlt, int n){
        if(n==0 || wtlt<=0){ return 0; }                               // base case
        if(wts[n-1]>wtlt){ return knapSack(wts, vals, wtlt, n-1); }    // current item's weight exceeding the limit of bag
        int op1 = vals[n-1] + knapSack(wts, vals, wtlt-wts[n-1], n-1); // including current item
        int op2 = knapSack(wts, vals, wtlt, n-1);                      // not including current item
        int max = op1>op2 ? op1:op2;
        return max;
    }
    
    public static void main(String[] args) throws Exception {
        int wts[] = {10, 20, 30};
        int vals[] = {60, 100, 120};
        int wtlt = 50;                                                 // bag limit for weights
        System.out.print("Max profit = " + knapSack(wts, vals, wtlt, wts.length));
    }
}


// ans = 220
