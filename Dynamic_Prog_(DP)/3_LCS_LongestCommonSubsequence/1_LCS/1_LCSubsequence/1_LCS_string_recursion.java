/**

Longest Common Subsequence (LCS) - Aditya Hurditya = 5(ditya) 
NOTE- continuity doesn't matter
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



/**

same code (but smaller)

import java.util.*;
import java.lang.Math;
public class Main {
    
    public static int LCS(String s1, String s2, int m, int n){
        if(m == 0 || n == 0) return 0;                                            // base case m=0 or n=0  -->  ans = 0
        if(s1.charAt(m-1) == s2.charAt(n-1)) return 1 + LCS(s1, s2, m-1, n-1);    // starting from last char of both (if mathes --> +1 and move both)
        return Math.max(LCS(s1, s2, m, n-1), LCS(s1, s2, m-1, n));                // if not match --> max of (move 1, move 2)
    }
    
    public static void main(String[] args) throws Exception {
        String s1 = "aditya";
        String s2 = "hurditya";
        System.out.println(LCS(s1, s2, s1.length(), s2.length()));
    }
}



**/
