/*
 question - find the number of pair of subsets that can be formed having difference of their total = given difference.
 
 NOTE - same as count of subsetSum
 
 but instead of argument sum, our sum is ((total arr[])/2)+diff   that it!!
*/


import java.util.*;

public class Main {
    
    // find sum of the original array
    public static int findSum(int[] arr){
        int sum = 0;
        for(int i=0; i<arr.length; i++){ sum += arr[i]; }
        return sum;
    }
    
    public static int ans(int[] arr, int sum, int n, int[][] store){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=sum; j++){
                if(arr[i-1]>j){ store[i][j]=store[i-1][j]; } // current num > sum --> not selected
                else{
                    int op1 = store[i-1][j];                 // not selected
                    int op2 = store[i-1][j-arr[i-1]];        // selected
                    store[i][j] = op1+op2;                   // both selected and non selected
                }
            }
        }return store[n][sum];
    }
    
    public static int ans(int[] arr, int sum, int n){
        int[][] store = new int[n+1][sum+1];
        // base case initialization
        for(int j=0; j<=sum; j++){ store[0][j] = 0; }
        for(int i=0; i<=n; i++){ store[i][0] = 1; }
        return ans(arr, sum, n, store);
    }
    
    public static void main(String[] args) throws Exception {
        int arr[] = {1,1,2,3};       // given
        int diff=1;                  // given
        int sum = findSum(arr);
        sum = (sum/2)+diff;          // trick
        System.out.println("Ans = " + ans(arr, sum, arr.length));
    }
}


// ans = 3  -->   ({1,1,2}{3}), ({1,2}{1`,3}), ({1`,2},{1,3})
