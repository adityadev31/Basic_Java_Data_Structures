import java.util.*;

public class Main {
    
    public static boolean ans(int arr[], int sumLeft, int n, boolean[][] store){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=sumLeft; j++){
                if(arr[i-1]>j){ store[i][j] = store[i-1][j]; } // num > left -> not selected
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
    
    public static boolean ans(int arr[], int sumLeft, int n){
        boolean store[][] = new boolean[n+1][sumLeft+1];
        // initialization (base case)
        for(int i=0; i<=n; i++){
            for(int j=0; j<=sumLeft; j++){
                if(i==0 && j==0){ store[i][j]=true; }
                else{
                    if(j==0){ store[i][j]=true; }
                    if(i==0){ store[i][j]=false; }
                }
            }
        }
        return ans(arr, sumLeft, n, store);
    }
    
    public static void main(String[] args) throws Exception {
        int[] arr = {2,4,8,5,10};
        int sumLeft = 13;
        System.out.println("ans = " + ans(arr, sumLeft, arr.length));
    }
}

// ans = true
