/**

Longest Common Subsequence (LCS) - Aditya Hurditya = 5(ditya)
Using String and DP

**/


import java.util.*;

public class Main {

    public static int LCS(String s1, String s2, int n, int m, int[][] store){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){ store[i][j]=1+store[i-1][j-1]; }  // current items matched
                else{
                    int op1 = store[i][j-1];             // keeping s1 char and leaving s2 char
                    int op2 = store[i-1][j];             // keeping s1 char and leaving s2 char
                    store[i][j] = (op1>op2)?op1:op2;
                }
            }
        }return store[n][m];
    }

    public static int LCS(String s1, String s2, int n, int m){
        int[][] store = new int[n+1][m+1];
        // initializing base case
        for(int i=0; i<=n; i++){ store[i][0] = 0; }
        for(int j=0; j<=m; j++){ store[0][j] = 0; }
        return LCS(s1, s2, n, m, store);
    }
    
    public static void main(String[] args) throws Exception {
        String s1 = "Aditya";
        String s2 = "Hurditya";
        System.out.println("Substring = " + LCS(s1, s2, s1.length(), s2.length()));
    }
}

// ans = 5
