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
    
    public static int MP(String str, int i, int j){
        if(i>=j){ return 0; }                                // no partitions required
        if(isPalindrome(str, i, j) == true){ return 0; }     // no partitions required
        
        int min = Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            int temp = 1 + MP(str, i, k) + MP(str, k+1, j);
            if(temp < min){ min = temp; }
        }
        return min;
    }
    
    public static void main(String[] args) throws Exception {
        String str = "nitik";
        System.out.println(MP(str, 0, str.length()-1));
    }
}

// ans = n|iti|k --> 2
