/**

problem statement - find whether it is possible to make sum of selected numbers from the array same as the given sum 
(same as knapsack - we have choice whether to select no. from the array or not)

**/




import java.util.*;

public class Main {
    
    public static boolean ans(int[] arr, int sumLeft, int n){
        if(sumLeft==0){ return true; }    // base case
        if(n==0){ return false; }         // base case
        if(arr[n-1]>sumLeft){ return ans(arr, sumLeft, n-1); }   // not selected (current item greater than sumLeft)
        boolean op1 = ans(arr, sumLeft-arr[n-1], n-1);           // selected
        boolean op2 = ans(arr, sumLeft, n-1);                    // not selected
        if(op1==true || op2==true)              
            return true;
        return false;
    }
    
    public static void main(String[] args) throws Exception {
        int arr[] = {2,8,7,1,5};
        int sumLeft = 14;
        System.out.println("Find ans = " + ans(arr, sumLeft, arr.length));
    }
}

// ans = true   (8+1+5=14)
