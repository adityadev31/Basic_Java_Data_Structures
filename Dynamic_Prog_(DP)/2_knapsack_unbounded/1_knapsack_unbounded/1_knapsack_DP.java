/*
    in unbounded knapsack multiple occurances are allowed
    
    NOTE :- if something selected then we can select it again and again
            but if something is rejected then we will not include it in bag any further
*/

import java.util.*;

public class Main {
    
    public static int knapsack(int[] wts, int[] vals, int bagSpace, int n, int[][] store){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=bagSpace; j++){
                if(wts[i-1]>j){ store[i][j] = store[i-1][j]; }// if item>space --> rejected (i.e. move forward i.e. i-1)
                else{
                    int op1 = store[i-1][j]; // rejected (i.e. move forward i.e. i-1)
                    int op2 = vals[i-1] + store[i][j-wts[i-1]]; // selected (i.e. can be repeated i.e. i=i)
                    store[i][j] = (op1>op2)?op1:op2;
                }
            }
        }
        return store[n][bagSpace];
    }
    
    public static int knapsack(int[] wts, int[] vals, int bagSpace, int n){
        int[][] store = new int[n+1][bagSpace+1];
        for(int j=0; j<=bagSpace; j++){ store[0][j] = 0; } // (n=0) when item =0 profit =0
        for(int i=0; i<=n; i++){ store[i][0] = 0; } // space=0 profit=0 no matter how much items we have
        return knapsack(wts, vals, bagSpace, n, store);
    }
    
    public static void main(String[] args) throws Exception {
        int[] wts = {20, 40, 10, 30, 10};
        int[] vals = {100, 200, 90, 50, 80};
        int bagSpace = 60;
        System.out.println("Ans = " + knapsack(wts, vals, bagSpace, wts.length));
    }
}

// ans = 540
