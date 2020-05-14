/*

question - longest palindrome sequence

example - given s1=abbbbca here longest palindromic sequence is abbbba i.e, ans = 6

Hint - s1=abbbbca  and s2=reverse(s1)-> s2=acbbbbba 
       now simply find the LCS and that will be the answer

*/


import java.util.*;

public class Main {
    
    // function to reverse string (recursive)
    public static String reverseString(String s1){
        if(s1.length()==0){ return ""; }   // base case 
        String small = reverseString(s1.substring(1));
        return small+s1.substring(0,1);
    }
    
    // longest common subsequence
    public static int LCS(String s1, String s2, int m, int n, int[][] store){
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){ store[i][j]=1+store[i-1][j-1]; } // if matches then i-1 j-1 and +1
                else{
                    int op1 = store[i-1][j];  // leaving i taking j 
                    int op2 = store[i][j-1];  // vice versa
                    store[i][j] = (op1>op2)?op1:op2;
                }
            }
        }return store[m][n];
    }
    
    // longest common subsequence (initialization)
    public static int LCS(String s1, String s2, int m, int n){
        int[][] store = new int[m+1][n+1];
        for(int i=0; i<=m; i++){ store[i][0]=0; } // base case
        for(int j=0; j<=n; j++){ store[0][j]=0; } // base case
        return LCS(s1, s2, m, n, store);
    }
    
    // helping function
    public static int Palindrome(String s1){
        String s2 = reverseString(s1);
        return LCS(s1, s2, s1.length(), s2.length());
    }
    
    // main function
    public static void main(String[] args) throws Exception {
        String s1 = "abbbbca";        
        System.out.println("Ans = " + Palindrome(s1));
    }
}

// ans = 6
