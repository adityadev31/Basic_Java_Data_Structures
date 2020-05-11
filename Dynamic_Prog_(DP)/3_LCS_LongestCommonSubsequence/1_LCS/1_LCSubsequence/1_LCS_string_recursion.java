/**

Longest Common Subsequence (LCS) - Aditya Hurditya = 5(ditya)
Using String and Recursion

**/


import java.util.*;

public class Main {

    public static int LCS(String s1, String s2, int n, int m){
        // base case
        if(n==0 || m==0){ return 0;}
        // choice case
        if(s1.charAt(n-1)==s2.charAt(m-1)){ return (1+LCS(s1, s2, n-1, m-1)); } // char match
        else{
            int op1 = LCS(s1, s2, n, m-1);  // select char of s1 leave s2
            int op2 = LCS(s1, s2, n-1, m);  // select char of s2 leave s1
            int max = (op1>op2)?op1:op2;
            return max;
        }
    }
    
    public static void main(String[] args) throws Exception {
        String s1 = "Aditya";
        String s2 = "Hurditya";
        System.out.println("Substring = " + LCS(s1, s2, s1.length(), s2.length()));
    }
}

// ans = 5
