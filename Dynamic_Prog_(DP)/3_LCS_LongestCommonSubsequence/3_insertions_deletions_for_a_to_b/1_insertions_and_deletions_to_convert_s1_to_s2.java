/*

quest - to find no. of insertions and deletions required to convert s1 into s2

example - s1 = hurditya, s2 = aditya, then inserting 'a' in s1 and deleting 'urd' in s1

HINT - no. of insertions = s2.len - LCS(longest common subsequence)
       no. of deletions  = s1.len - LCS

*/


import java.util.*;

public class Main {
    
    // longest common subsequence
    public static int LCS(String s1, String s2, int m, int n, int[][] store){
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){ store[i][j]=1+store[i-1][j-1]; } // same char hence i-1 j-1 and +1
                else{
                    int op1 = store[i][j-1];         // not same hence keeping char at s1 and leaving char at s2
                    int op2 = store[i-1][j];         // vice versa of the above
                    store[i][j] = (op1>op2)?op1:op2; // storing the max length
                }
            }
        }return store[m][n];
    }
    
    public static int LCS(String s1, String s2, int m, int n){
        int[][] store = new int[m+1][n+1];
        for(int i=0; i<=m; i++){ store[i][0]=0; } // base case
        for(int j=0; j<=n; j++){ store[0][j]=0; } // base case
        return LCS(s1, s2, m, n, store);
    }
    
    public static void main(String[] args) throws Exception {
        String s1 = "HURDITYA";
        String s2 = "ADITYA";
        int insertions = s2.length()-LCS(s1, s2, s1.length(), s2.length());
        int deletions = s1.length()-LCS(s1, s2, s1.length(), s2.length());
        System.out.println("insertions = " + insertions);
        System.out.println("deletions = " + deletions);
    }
}

/*
    insertions = 1
    deletions = 3
*/
