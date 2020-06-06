/**

quest - printing shortest common subsequence i.e, min len string which contains both the strings

**/


import java.util.*;
import java.lang.Math;

public class Main {
    
    public static StringBuilder LCS(String s1, String s2, int n, int m, int[][] store){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){ store[i][j] = 1+store[i-1][j-1]; }
                else{ store[i][j] = Math.max(store[i-1][j],store[i][j-1]); }
            }
        }
        
        // print
        int i=n, j=m;
        StringBuilder result = new StringBuilder();
        while(i!=0 && j!=0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                result.append(s1.charAt(i-1));
                i--;
                j--;
            }
            else{
                if(store[i-1][j] == store[i][j-1]){
                    if(j>0){ j--; }
                    else{ i--; }
                }
                else{
                    if(store[i-1][j]>store[i][j-1]){ i--; }
                    else{ j--; }
                }
            }
        }return result.reverse();
    }
    
    public static StringBuilder LCS(String s1, String s2, int n, int m){
        int[][] store = new int[n+1][m+1];
        for(int i=0; i<=n; i++){ store[i][0]=0; }
        for(int j=0; j<=m; j++){ store[0][j]=0; }
        return LCS(s1, s2, n, m, store);
    }
    
    public static String printSCS(String s1, String s2, int n, int m){
        StringBuilder lcs = LCS(s1, s2, n, m);
        String scs = "";
        int i=0, j=0, k=0;
        while(i<n && j<m && k<lcs.length()){
            // if any of charAt s1 or s2 belongs to lcs then stop that and move other
            if(s1.charAt(i)==lcs.charAt(k) || s2.charAt(j)==lcs.charAt(k)){
                if(s1.charAt(i) == s2.charAt(j)){     // same and both belong to lcs then add & move both
                    scs += s1.charAt(i);
                    i++;
                    j++;
                    k++;
                }
                else{
                    if(s1.charAt(i)==lcs.charAt(k)){  // if s2 not matches add s2
                        scs += s2.charAt(j);
                        j++;                          // and increment j till matches with i and lcs
                    }
                    else{
                        scs += s1.charAt(i);
                        i++;
                    }
                }
            }
            else{                                     // none of them matches with lcs
                scs += s1.charAt(i);                  // add both increment both
                scs += s2.charAt(j);
                i++;
                j++;
            }
        }
        while(i<n){ scs += s1.charAt(i++); }          // adding the remains
        while(j<m){ scs += s2.charAt(j++); }          // adding the remains
        return scs;
    }
    
    public static void main(String[] args) throws Exception {
        String s1 = "acbcfm";
        String s2 = "abcdafn";
        System.out.println("min deletions = "+printSCS(s1, s2, s1.length(), s2.length()));
    }
}

// lcs --> abcf
// scs --> acbcdafmn
