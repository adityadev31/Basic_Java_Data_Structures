import java.util.*;

public class Main {
    
    public static int findSum(int arr[]){
        int sum = 0;
        for(int i=0; i<arr.length; i++){ sum = sum + arr[i]; }
        return sum;
    }
    
    public static boolean ans(int[] arr, int sumLeft, int n, boolean[][] store){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=sumLeft; j++){
                if(arr[i-1]>j){ store[i][j] = store[i-1][j]; } // not selected
                else{
                    boolean op1 = store[i-1][j-arr[i-1]];  // selected
                    boolean op2 = store[i-1][j];           // not selected
                    if(op1==true||op2==true)
                        store[i][j] = true;
                    else
                        store[i][j] = false;
                }
            }
        }
        return store[n][sumLeft];
    }
    
    public static boolean ans(int[] arr, int sumLeft, int n){
        boolean store[][] = new boolean[n+1][sumLeft+1];
        // initialization (base case)
        for(int j=0; j<=sumLeft; j++){ store[0][j] = false; }
        for(int i=0; i<=n; i++){ store[i][0] = true; }
        return ans(arr, sumLeft, n, store);
    }
    
    public static void main(String[] args) throws Exception {
        int arr[] = {1, 5, 13, 7};
        int sum = findSum(arr);
        boolean result = (sum%2==0)?ans(arr, sum/2, arr.length):false;
        System.out.println("ans = " + result);
    }
}

// ans = true
