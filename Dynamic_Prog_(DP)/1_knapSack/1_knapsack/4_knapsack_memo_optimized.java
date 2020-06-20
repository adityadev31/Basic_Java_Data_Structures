// checking before every recursive call

import java.util.*;

public class Main {
    
    public static int knap(int[] wt, int[] val, int bag, int n){
        int[][] store = new int[n+1][bag+1];
        Arrays.stream(store).forEach(a->Arrays.fill(a,-1));
        return knap(wt, val, bag, n, store);
    }
    
    public static int knap(int[] wt, int[] val, int bag, int n, int[][] store){
        if(n==0 || bag==0) return 0;
        if(store[n][bag]!=-1) return store[n][bag];
        if(wt[n-1]>bag){
            if(store[n-1][bag]!=-1) return store[n][bag] = store[n-1][bag];
            store[n-1][bag] = knap(wt, val, bag, n-1, store);
            return store[n][bag] = store[n-1][bag];
        }
        else{
            int op1, op2;
            // skip
            if(store[n-1][bag]!=-1){ op1 = store[n-1][bag]; }
            else{
                store[n-1][bag] = knap(wt, val, bag, n-1, store);
                op1 = store[n-1][bag];
            }
            // include
            if(store[n-1][bag-wt[n-1]]!=-1){ op2 = val[n-1] + store[n-1][bag-wt[n-1]]; }
            else{
                store[n-1][bag-wt[n-1]] = knap(wt, val, bag-wt[n-1], n-1, store);
                op2 = val[n-1] + store[n-1][bag-wt[n-1]];
            }
            store[n][bag] = op1>op2?op1:op2;
        }
        return store[n][bag];
    }
    
    public static void main(String[] args) throws Exception {
        int[] wt = {10, 7, 4, 5, 2};
        int[] val = {100, 70, 40, 50, 30};
        int bag = 20;
        System.out.println(knap(wt, val, bag, wt.length));
    }
}

// ans = 200
