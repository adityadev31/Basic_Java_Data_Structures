/**

    given coins[] = {5,5,2,1}
    
    find min coins to full fill sum = 7
    
    if not then return -1
    
    possibilities:- (5,2) (1,1,1,1,1,1,1) (2,2,2,1) and so on..  so req ans = 2 coz (5,2);
	
	~ H I N T - same as unbound knapsack just fill initialize base case i=0 with min/max int ~

**/



import java.util.*;

public class Main {
    
    public static int minCoins(int[] arr, int n, int sum, int[][] store){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=sum; j++){
                if(arr[i-1] > j) store[i][j] = store[i-1][j];
                else store[i][j] = Math.min(store[i-1][j], 1+store[i][j-arr[i-1]]);
            }
        }return store[n][sum];
    }
    
    public static int minCoins(int[] arr, int n, int sum){
        int[][] store = new int[n+1][sum+1];
        for(int j=0; j<=sum; j++) store[0][j] = Integer.MAX_VALUE-n; // if no items then min req coins = max_int **  rest same as unbound knapsack
        for(int i=0; i<=n; i++) store[i][0] = 0;                     // sum = 0  then min req coins = 0
        return minCoins(arr, n, sum, store);
    }
    
    public static void main(String[] args) throws Exception {
        int coins[] = {5,5,2,1};
        int sum = 7;
        System.out.println(minCoins(coins, coins.length, sum));
    }
}

// ans = 2

//    ** Integer.MAX_VALUE + 1 = Integer.MIN_VALUE hence we have to take little less than max   ;)   
//    we have filled max int i=0 coz we have to find min        see if we had to find max then we would fill it with min
 
