/*
  question - min deletions to make a string palindromic
  
  HINT - same as palindrome ..... ans = (s1.len - LCS)
  
*/

import java.util.*;

public class Main {
    
    // reverse string function
    public static String reverse(String s1){
        if(s1.length()==0){ return ""; }  // base case
        String small = reverse(s1.substring(1));
        return small+s1.substring(0,1);
    }
    
    // longest common sequence
    public static int LCS(String s1, String s2, int m, int n, int[][] store){
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){ store[i][j]=1+store[i-1][j-1]; } // both char mathches... move forward in both +1
                else{
                    int op1 = store[i-1][j];    // case1
                    int op2 = store[i][j-1];    // case2
                    store[i][j] = (op1>op2)?op1:op2;
                }
            }
        }return store[m][n];
    }
    
    public static int LCS(String s1, String s2, int m, int n){
        int[][] store = new int[m+1][n+1];
        for(int i=0; i<=m; i++){ store[i][0]=0; }  // base case initialization
        for(int j=0; j<=n; j++){ store[0][j]=0; }  // base case initialization
        return LCS(s1, s2, m, n, store);
    }
    
    public static int palindrome(String s1){
        String s2 = reverse(s1);
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
        return s1.length()-LCS(s1, s2, s1.length(), s2.length()); // (s1.len - LCS)
    }
    
    public static void main(String[] args) throws Exception {
        String s1="ab12b3a";
        System.out.println("Ans = " + palindrome(s1));
    }
}

// ans = 2
