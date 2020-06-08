/**

quest - Matrix chain multiplication

matrix = arr[i-1]*arr[i]

if  arr = {10, 20, 30}

then mat1 = 10*20
then mat2 = 20*30

and no. of multiplications of mat1 and mat2 = 10*20*30

hence i will start from 1 index due to arr[i-1]*arr[i] (i.e, for the existence of 1 matrix we need both current and previous indexes)
and j will be at the end only

**/


import java.util.*;
import java.lang.Math;


public class Main {
    
    public static int MCM(int[] arr, int i, int j, int[][] store){
        if(i>=j){ return 0; }
    
        if(store[i][j]!=-1){ return store[i][j]; }         // memoize before making recursion calls
        
        int min = Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            int op1, op2, op3;
            // int op1 = MCM(arr, i, k, store);
            if(store[i][k]!=-1){ op1 = store[i][k]; }   // memoize before recursive call 
            else{
                op1 = MCM(arr, i, k, store);     // if not then solve recursivelly and insertin store
                store[i][k] = op1;
            }
            
            // int op2 = MCM(arr, k+1, j, store);
            if(store[k+1][j]!=-1){ op2 = store[k+1][j]; }
            else{
                op2 = MCM(arr, k+1, j, store);
                store[k+1][j] = op2;
            }
            
            // op3 as it is
            op3 = arr[i-1]*arr[k]*arr[j];
            
            int temp = op1+op2+op3;
            if(temp < min){ min = temp; }
        }
        store[i][j] = min;
        return min;
    }
    
    public static int MCM(int[] arr, int i, int j){
        int[][] store = new int[1001][1001];                     // size according to constraints of i and j
        Arrays.stream(store).forEach(a -> Arrays.fill(a, -1));   // initializing store array with -1
        return MCM(arr, i, j, store);
    }
    
    public static void main(String[] args) throws Exception {
        int[] arr = {40, 20, 30, 10, 30};
        System.out.println(MCM(arr, 1, arr.length-1));
    }
}

// ans = (A(BC))D --> 20*30*10 + 40*20*10 + 40*10*30 = 26000
