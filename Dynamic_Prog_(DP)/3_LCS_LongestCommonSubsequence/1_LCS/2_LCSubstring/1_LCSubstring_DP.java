/*
   longest common substring is same as longest common subset but 
   the diff is that whenever we find a breaking point we will again set it to 0 and find the max continuous substring
   ex- Aditya    and     Adxxitya      there are two continuous substrings = Ad & itya since itya>AD hence ans = 4
*/


import java.util.*;

public class Main {
    
    public static int LCS(String s1, String s2, int m, int n, int[][] store){
        int result=0;
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){        // chars matched
                    store[i][j]=1+store[i-1][j-1]; 
                    result = (result>store[i][j])?result:store[i][j]; // result will store the max of the matched strings found
                }
                else{ store[i][j]=0; }  // not matched (reset with 0)
            }
        }return result;
    }
    
    public static int LCS(String s1, String s2, int m, int n){
        int store[][] = new int[m+1][n+1];
        for(int i=0; i<=m; i++){ store[i][0]=0; }
        for(int j=0; j<=n; j++){ store[0][j]=0; }
        return LCS(s1, s2, m, n, store);
    }
    
    public static void main(String[] args) throws Exception {
        String s1 = "Aditya";
        String s2 = "Adxxitya";
        System.out.println("Ans = " + LCS(s1, s2, s1.length(), s2.length()));
    }
}

// ans = 4
