import java.util.*;

public class Main {
    
    public static int targetSum(int[] arr, int n, int sum, int[][] store){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=sum; j++){
                if(arr[i-1] > j) store[i][j] = store[i-1][j];                // current item > sum left
                else store[i][j] = store[i-1][j] + store[i-1][j-arr[i-1]];   // selected + not selected = total ways  
            }
        }
        return store[n][sum];
    }
    
    public static int targetSum(int[] arr, int n, int sum){
        int[][] store = new int[n+1][sum+1];
        for(int j=0; j<=sum; j++){ store[0][j]=0; }  // initializing base case
        for(int i=0; i<=n; i++){ store[i][0]=1; }    // initializing base case
        return targetSum(arr, n, sum, store);
    }
    
    public static void main(String[] args) throws Exception {
        int[] arr = {1,3,2,4,5};
        int target = 8;
        System.out.println(targetSum(arr, arr.length, target));
    }
}

// ans = 3
