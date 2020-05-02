/**
problem - given an array, find whether its possible to divide array into two subsets have their sum as equal.
HINT - for this the sum of all the elements of the original array must be an even number
HINT - same as previous subsetSum problem just find for sumLeft = sumOfArray/2
example = arr[] = {1,5,13,7} => sum = 26 i.e sum/2 = 13   so, find for 13 => {13} {1,5,7} 
**/

import java.util.*;

public class Main {
    
    public static int findSum(int arr[]){
        int sum = 0;
        for(int i=0; i<arr.length; i++){ sum = sum + arr[i]; }
        return sum;
    }
    
    public static boolean ans(int[] arr, int sumLeft, int n){
        if(sumLeft==0){ return true; }  // base case
        if(n==0){ return false; }       // base case
        if(arr[n-1]>sumLeft){ return ans(arr, sumLeft, n-1); } // not selected
        else{
            boolean op1 = ans(arr, sumLeft-arr[n-1], n-1);     // selected
            boolean op2 = ans(arr, sumLeft, n-1);              // not selected
            if(op1==true || op2==true)
                return true;
            else
                return false;
        }
    }
    
    public static void main(String[] args) throws Exception {
        int arr[] = {1, 5, 13, 7};
        int sum = findSum(arr);
        boolean result = (sum%2==0)?ans(arr, sum/2, arr.length):false;
        System.out.println("ans = " + result);
    }
}

// ans = true
