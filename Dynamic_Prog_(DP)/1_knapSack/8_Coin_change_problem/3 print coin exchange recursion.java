import java.util.*;

public class Main {
    
    public static SortedSet<String> ts = new TreeSet<>();      // for sorted unique elements
    
    public static void targetSum(int[] arr, int n, int sum, String ans){
        if(sum == 0){
            ts.add("("+ans+")");
            return;
        }
        if(n == 0) return;
        if(arr[n-1] > sum) targetSum(arr, n-1, sum, ans);  // not selected coz current item > sum
        targetSum(arr, n-1, sum, ans);                                      // not selected
        targetSum(arr, n-1, sum-arr[n-1], String.valueOf(arr[n-1])+ans);    // selected
    }
    
    public static void main(String[] args) throws Exception {
        int[] arr = {1,4,3,2,5};
        int sum = 8;
        targetSum(arr, arr.length, sum, "");
        System.out.println(ts);
    }
}

// ans = [(125), (143), (35)]
