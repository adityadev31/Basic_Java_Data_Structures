/**

quest - Min partitions to make a palindromes

ex - nitik -->  n | iti | k   --> i.e, 2 partitions

**/


import java.util.*;


public class Main {
    
    // fuction to check palindrome
    public static boolean isPalindrome(String str, int i, int j){
        boolean flag = true;
        while(i<j){
            if(str.charAt(i)==str.charAt(j)){ i++; j--; }
            else{
                flag = false;
                break;
            }
        }return flag;
    }
    
    public static int MP(String str, int i, int j, int[][] store){
        if(i>=j){ return 0; }                                // no partitions required
        if(isPalindrome(str, i, j) == true){ return 0; }     // no partitions required
        
        if(store[i][j]!=-1){ return store[i][j]; }           // memoize before everyrecursive call
        
        int min = Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            int left, right;
        
            if(store[i][k]!=-1){ left = store[i][k]; }    // left
            else{
                left = MP(str, i, k, store);
                store[i][k] = left;
            }
            
            if(store[k+1][j]!=-1){ right = store[k+1][j]; }   // right
            else{
                right = MP(str, k+1, j, store);
                store[k+1][j] = right;
            }
            
            // int temp = 1 + MP(str, i, k) + MP(str, k+1, j);
            int temp = 1 + left + right;
            if(temp < min){ min = temp; }
        }
        store[i][j] = min;
        return min;
    }
    
    
    public static int MP(String str, int i, int j){
        int n = str.length();
        int[][] store = new int [n+1][n+1];
        Arrays.stream(store).forEach(a->Arrays.fill(a, -1));
        return MP(str, i, j, store);
    }
    
    public static void main(String[] args) throws Exception {
        String str = "nitik";
        System.out.println(MP(str, 0, str.length()-1));
    }
}

// ans = n|iti|k --> 2
