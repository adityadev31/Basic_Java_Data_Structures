/**
quest - we have to find the number of subsets that can be formed having sum of their elements = given no. (sum)
**/

import java.util.*;

public class Main {
    
    public static int ans(int[] arr, int sum, int n){
        // base case
        if(sum==0){ return 1; }
        if(n==0){ return 0; }
        // choice case
        if(arr[n-1]>sum){ return ans(arr, sum, n-1); }
        else{
            int selected = ans(arr, sum-arr[n-1], n-1);
            int notSelected = ans(arr, sum, n-1);
            return selected + notSelected;
        }
    }
    
    public static void main(String[] args) throws Exception {
        int[] arr = {1,3,7,9,2,8,10};
        int sum=10;
        System.out.println("Ans = " + ans(arr, sum, arr.length));
    }
}


/**
ans = 5   -->  {1,9}, {1,2,7}, {2,8}, {3,7}, {10}
**/
