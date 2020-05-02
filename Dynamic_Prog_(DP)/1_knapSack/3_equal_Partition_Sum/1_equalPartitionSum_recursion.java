import java.util.*;

public class Main {
    
    public static int findSum(int arr[]){
        int sum = 0;
        for(int i=0; i<arr.length; i++){ sum = sum + arr[i]; }
        return sum;
    }
    
    public static boolean ans(int[] arr, int sumLeft, int n){
        if(sumLeft==0){ return true; }
        if(n==0){ return false; }
        if(arr[n-1]>sumLeft){ return ans(arr, sumLeft, n-1); } // not selected
        else{
            boolean op1 = ans(arr, sumLeft-arr[n-1], n-1);     // selected
            boolean op2 = ans(arr, sumLeft, n-1);              // not selected
            if(op1==true || op2==true)
                return true;
            else
                return false;
        }
    }
    
    public static void main(String[] args) throws Exception {
        int arr[] = {1, 5, 13, 7};
        int sum = findSum(arr);
        boolean result = (sum%2==0)?ans(arr, sum/2, arr.length):false;
        System.out.println("ans = " + result);
    }
}

// ans = true
