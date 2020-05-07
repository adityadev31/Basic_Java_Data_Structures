import java.util.*;

public class Main {
    
    public static int totalSum(int[] arr){
        int sum = 0;
        for(int i=0; i<arr.length; i++){ sum += arr[i]; }
        return sum;
    }
    
    public static int ans(int[] arr, int sum, int n, int[][] store){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=sum; j++){
                if(arr[i-1]>j){ store[i][j] = store[i-1][j]; } // if current item > sum required --> not selected
                else{ store[i][j] = store[i-1][j] + store[i-1][j-arr[i-1]]; } // sum of both selected and non selected
            }
        }
        return store[n][sum];
    }
    
    public static int ans(int[] arr, int sum, int n){
        int[][] store = new int[n+1][sum+1];
        // initialization (base case)
        for(int j=0; j<=sum; j++){ store[0][j]=0; }  // if item = 0 then sumLeft will always be zero (i=0, 0<=j<=sum --> zero)
        for(int i=0; i<=n; i++){ store[i][0]=1; }    // if sumLeft == 0  -->  0<=i<=n -->1   (null set)
        return ans(arr, sum, n, store);
    }
    
    public static void main(String[] args) throws Exception {
        int[] arr = {1,3,7,9,2,8};
        int sum=10;
        if(totalSum(arr)<sum)
            System.out.println("ans = 0");
        else if(totalSum(arr)==sum)
            System.out.println("ans = 1");
        else
            System.out.println("ans = " + ans(arr, sum, arr.length));
    }
}

// ans = 5   -->   {1,9}, {1,2,7}, {2,8}, {3,7}, {10}
