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
    
    public static int MCM(int[] arr, int i, int j){
        if(i>=j){ return 0; }
        int min = Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            int op1 = MCM(arr, i, k);
            int op2 = MCM(arr, k+1, j);
            int op3 = arr[i-1]*arr[k]*arr[j];    // starting * common * end
            int sum = op1+op2+op3;
            if(sum < min){ min = sum; }
        }
        return min;
    }
    
    public static void main(String[] args) throws Exception {
        int[] arr = {40, 20, 30, 10, 30};
        System.out.println(MCM(arr, 1, arr.length-1));
    }
}

// ans = (A(BC))D --> 20*30*10 + 40*20*10 + 40*10*30
