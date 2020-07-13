/**

    given arr[] = {5,5,2,3,7,1}  partitions length allowed
    
    find max feasible partitions to full fill rodlen = 7
    
    if not then return -1
    
    possibilities:- (5,2) (1,1,1,1,1,1,1) (2,2,2,1) (7) and so on..  so req ans = 7 coz (1,1,1,1,1,1,1);

**/



import java.util.*;

public class Main {
    
    public static int maxParts(int[] arr, int n, int sum, int[][] store){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=sum; j++){
                if(arr[i-1] > j) store[i][j] = store[i-1][j];
                else store[i][j] = Math.max(store[i-1][j], 1+store[i][j-arr[i-1]]);
            }
        }
        if(store[n][sum] < 0) return -1;
        return store[n][sum];
    }
    
    public static int maxParts(int[] arr, int n, int sum){
        int[][] store = new int[n+1][sum+1];
        for(int j=0; j<=sum; j++) store[0][j] = Integer.MIN_VALUE;   // if no items then min req coins = max_int **     rest fully same as other unbounded problems
        for(int i=0; i<=n; i++) store[i][0] = 0;                     // sum = 0  then min req coins = 0
        return maxParts(arr, n, sum, store);
    }
    
    public static void main(String[] args) throws Exception {
        int len[] = {5,5,7,10};
        int sum = 13;
        System.out.println(maxParts(len, len.length, sum));
    }
}

//    ans = -1 coz no partition possible

/*
		int[] len = {5,5,2,7};  and  sum = 7
		then ans = 2 --> 5+2=7
*/

//    we have filled min int i=0 coz we have to find max        see if we had to find min then we would fill it with max
 
