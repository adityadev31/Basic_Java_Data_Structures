/* ---------S E L E C T I O N  -  S O R T ------------*/

import java.util.*;

public class Main {
    
    public static void selectionSort(int[] arr, int n){
        int temp = 0;
        for(int i=0; i<n-1; i++){
            swapped = false;
            for(int j=i+1; j<n; j++){
                if(arr[j]<arr[i]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        int arr[] = {4,1,3,2,7,5,6};
        selectionSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}


/* 
        O U T P U T
        
        [1, 2, 3, 4, 5, 6, 7]
*/

/*  
        T I M E  - C O M P L E X I T Y
        
        Time Complexity: O(n2) as there are two nested loops.

        Auxiliary Space: O(1)
*/
