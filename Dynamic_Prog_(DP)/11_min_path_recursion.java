import java.util.*;

public class Main {
    
    public static int findMinPath(int[][] arr, int row, int col){
        if(row<0 || col<0){ return Integer.MAX_VALUE; }            // base case 
        if(row==0 && col==0){ return arr[row][col]; }              // base case (if array size =1 then return that array element)
        int op1 = findMinPath(arr, row-1, col);                    // up
        int op2 = findMinPath(arr, row, col-1);                    // left
        int op3 = findMinPath(arr, row-1, col-1);                  // up-left
        int min = op1<op2?op1:op2;
        min = min<op3?min:op3;
        return arr[row][col] + min;                       
    }
    
    public static void main(String[] args) throws Exception {
        int[][] arr = {
            {1,3,6,2},
            {6,2,7,3},
            {6,2,3,1}
        };
        int row = arr.length-1;
        int col = arr[0].length-1;
        System.out.println("Min path = " + findMinPath(arr, row, col));
    }
}

// ans = 7 (1->2->3->1 = 7)
