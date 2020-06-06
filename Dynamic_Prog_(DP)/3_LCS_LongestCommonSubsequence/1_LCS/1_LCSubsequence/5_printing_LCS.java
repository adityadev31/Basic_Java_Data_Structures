import java.util.*;
import java.lang.Math;

public class Main {
    
    public static StringBuilder LCS(String s1, String s2, int n, int m, int[][] store){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s1.charAt(i-1)!=s2.charAt(j-1)){ store[i][j]=Math.max(store[i-1][j], store[i][j-1]); }
                else{ store[i][j] = 1+store[i-1][j-1]; }
            }
        }
     
        // printing
        String result = "";
        StringBuilder result1 = new StringBuilder(); 
        int i=n, j=m;
        while(i!=0 && j!=0){
            // if letters are same then move diagonally
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                result += s1.charAt(i-1);
                i--;
                j--;
            }
            // if not same then check the maximum of adjacents
            else{
                // if adjacents are same 
                if(store[i][j-1] == store[i-1][j]){
                    if(j>0){ j--; }
                    else{ i--; }
                }
                // if adjacents are not same then move to max adjacent
                else{
                    if(store[i-1][j] > store[i][j-1]){ i--; }
                    else{ j--; }
                }
            }
        }
        result1.append(result);
        return result1.reverse();
    }
    
    public static StringBuilder LCS(String s1, String s2, int n, int m){
        int[][] store = new int[n+1][m+1];
        for(int i=0; i<=n; i++){ store[i][0]=0; }
        for(int j=0; j<=m; j++){ store[0][j]=0; }
        return LCS(s1, s2, n, m, store);
    }
    
    public static void main(String[] args) throws Exception {
        String s1 = "aditya";
        String s2 = "hurditya";
        System.out.println(LCS(s1, s2, s1.length(), s2.length()));
    }
}


// ans --> ditya
