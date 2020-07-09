/**

given array[] = {1,2,3,4,5}
given target = 8
find no. of unique combinations of elements from array to give (total sum = target)

ans = 3   -->  (1,2,5) (1,3,4) (3,5)   selected elements should not be repeated int the same combination

**/



import java.util.*;

public class Main {
    
    public static int targetSum(int[] arr, int n, int sum){
        if(sum == 0) return 1;    // base case   (sum left = 0 --> ans)
        if(n == 0) return 0;      // base case
        if(arr[n-1] > sum) return targetSum(arr, n-1, sum);  // current item > sum left
        int op1 = targetSum(arr, n-1, sum);                  // leave and move
        int op2 = targetSum(arr, n-1, sum-arr[n-1]);         // select and move
        return op1+op2;                                      // total ways
    }
    
    public static void main(String[] args) throws Exception {
        int[] arr = {1,3,2,4,5};
        int target = 8;
        System.out.println(targetSum(arr, arr.length, target));
    }
}

// ans = 3
