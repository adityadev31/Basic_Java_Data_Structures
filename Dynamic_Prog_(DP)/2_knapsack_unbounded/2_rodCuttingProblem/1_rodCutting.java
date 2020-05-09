/*
    question - rod cutting problem (exactly same as unbounded knapsack)
    
    given a rod, we have to cut it in different pieces also given the price according to length
    
    we have to find the maximum profit after cutting( or not cutting ) the rod
    
*/

import java.util.*;

public class Main {
    
    public static int rodProb(int[] len, int[] price, int rodLen, int n, int[][] store){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=rodLen; j++){
                if(len[i-1]>j){ store[i][j] = store[i-1][j]; }    // rejected
                else{
                    int op1 = store[i-1][j];                      // rejected (so i-1)
                    int op2 = price[i-1] + store[i][j-len[i-1]];  // selected (so i=i) (coz can be repeated)
                    store[i][j] = (op1>op2)?op1:op2;
                }
            }
        }return store[n][rodLen];
    }
    
    public static int rodProb(int[] len, int[] price, int rodLen, int n){
        int[][] store = new int[n+1][rodLen+1];
        // initializing base case
        for(int j=0; j<=rodLen; j++){ store[0][j] = 0; }  // when there is no piece no profit
        for(int i=0; i<=n; i++){ store[i][0] = 0; }       // when there is no rod no profit
        return rodProb(len, price, rodLen, n, store);
    }
    
    public static void main(String[] args) throws Exception {
        int[] len = {1,2,3,4};                    // pieces lengths
        int[] price = {100, 300, 90, 50};
        int rodLen = 4;                                   // rod of length 8 (initially given)
        System.out.println("Ans = " + rodProb(len, price, rodLen, len.length));
    }
}

// ans = 600 (2+2)-->300+300
