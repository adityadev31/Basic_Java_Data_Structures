import java.util.*;

public class Main {
    
    public static void targetSum(int[] arr, int n, int sum, String ans){
        if(sum == 0){
            System.out.print("("+ans+")");
            return;
        }
        if(n == 0) return;
        if(arr[n-1] > sum) targetSum(arr, n-1, sum, ans);  // not selected coz current item > sum
        else{
            targetSum(arr, n-1, sum, ans);                                      // not selected
            targetSum(arr, n-1, sum-arr[n-1], String.valueOf(arr[n-1])+ans);    // selected
        }
    }
    
    public static void main(String[] args) throws Exception {
        int[] arr = {1,1,4,3,2,5};
        int sum = 8;
        targetSum(arr, arr.length, sum, "");
    }
}

// ans = (143)(143)(1142)(35)(125)(125)
