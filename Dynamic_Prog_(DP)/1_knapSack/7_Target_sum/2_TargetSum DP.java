/*
  question - assign either +ve or -ve values to the elements of the array and find whether there is a combo or not having the given sum
  example - {1,1,2,3}  given sum = 1
  sol     - (1,1,2,-3), (-1,-2,3,1), (-1,-2,3,1) => ans = 3
  
  NOTE - this is exactly the same same question as finPairOfSubsetsWithGivenDifference problem
  
*/


import java.util.*;

public class Main {
    
    // find sum of the array elements
    public static int findSum(int[] arr){
        int sum = 0;
        for(int i=0; i<arr.length; i++){ sum += arr[i]; }
        return sum;
    }
    
    public static int ans(int arr[], int sum, int n, int store[][]){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=sum; j++){
                if(arr[i-1]>j){ store[i][j] = store[i-1][j]; } // current item> sum --> not selected
                else{
                    store[i][j] = store[i-1][j] + store[i-1][j-arr[i-1]];  // selected + not selected
                }
            }
        }return store[n][sum];
    }
    
    public static int ans(int arr[], int sum, int n){
        int store[][] = new int[n+1][sum+1];
        // initaializing base case
        for(int j=0; j<=sum; j++){ store[0][j]=0; }
        for(int i=0; i<=n; i++){ store[i][0]=1; }
        return ans(arr, sum, n, store);
    }
    
    public static void main(String[] args) throws Exception {
        int arr[] = {1,1,2,3};
        int sum = 1;
        sum = (findSum(arr)/2) + sum;
        System.out.println("ans = " + ans(arr, sum, arr.length));
    }
}

// ans = 3
