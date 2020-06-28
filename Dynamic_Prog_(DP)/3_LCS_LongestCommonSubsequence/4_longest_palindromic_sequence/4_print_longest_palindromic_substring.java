import java.util.*;
import java.lang.Math;

class Result{        // to remember the indexes of result to backtrack 
    public int len;
    public int i;
    public int j;
    Result(){
        this.len = Integer.MIN_VALUE;
        this.i = -1;
        this.j = -1;
    }
}

public class Main {
    
    public static String LCS(String s1, String s2, int n, int m, int[][] store){
        Result result = new Result();
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){		// if char matches then store + 1 and compare with result
                    store[i][j] = 1 + store[i-1][j-1];
                    if(store[i][j] > result.len){      // resetting result with our new answers if store > result
                        result.len = store[i][j];
                        result.i = i;
                        result.j = j;
                    }
                }
                else store[i][j]=0;
            }
        }
        
        if(result.len == 0) return "no match";   // just in case
        
        StringBuilder sb = new StringBuilder();
        
        int i=result.i, j=result.j;
        while(i>=0 && j>=0){
            if(store[i][j]==0) break;
            else{
                sb.append(s1.charAt(i-1));  // i-1 coz store[][] was actually i+1 && j+1
                i--; j--;
            }
        }
        
        String check1 = sb.toString();
        String check2 = sb.reverse().toString();
        if(check1.equals(check2)) return check1;   // checking if check1 == check2
        else return s1.substring(0,1);             // if no then return Ist char of s1
    }
     
    public static String LCS(String s1, String s2){
        int n1 = s1.length(), n2 = s2.length();
        int[][] store = new int[n1+1][n2+1];
        for(int i=0; i<=n1; i++){ store[i][0]=0; }  // initializing base case
        for(int j=0; j<=n2; j++){ store[0][j]=0; }  // initializing base case
        return LCS(s1, s2, n1, n2, store);
    }
    
    
    public static void main(String[] args) throws Exception {
        String s1 = "aaaabbaa";
        StringBuilder sb = new StringBuilder();
        sb.append(s1).reverse();
        String s2 = new String(sb.toString());
        System.out.println(LCS(s1, s2));
    }
}

// ans = aabbaa
