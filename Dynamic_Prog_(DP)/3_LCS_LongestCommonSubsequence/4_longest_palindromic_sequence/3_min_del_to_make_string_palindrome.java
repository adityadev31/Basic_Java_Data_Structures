import java.util.*;
import java.lang.Math;

public class Main {
    
    public static int LCS(String s1, StringBuilder s2, int n, int[][] store){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){ store[i][j] = 1+store[i-1][j-1]; }
                else{ store[i][j] = Math.max(store[i-1][j],store[i][j-1]); }
            }
        }return store[n][n];
    }
    
    public static int LCS(String s1, int n){
        StringBuilder s2 = new StringBuilder(); // using StringBuilder to reverse
        s2.append(s1);
        s2 = s2.reverse();
        int[][] store = new int[n+1][n+1];
        for(int i=0; i<=n; i++){ store[i][0]=0; }
        for(int j=0; j<=n; j++){ store[0][j]=0; }
        return LCS(s1, s2, n, store);
    }
    
    public static int findDel(String s1, int n){ return n-LCS(s1, n); }
    
    public static void main(String[] args) throws Exception {
        String s1 = "axxbbacxaba";
        System.out.println("min deletions = "+findDel(s1, s1.length()));
    }
}

// lcs --> abacaba
