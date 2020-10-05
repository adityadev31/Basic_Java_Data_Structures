/* -------------------B U B B L E  -  S O R T ---------------------- */

import java.util.*;

public class Main {
    
    public static void bubbleSort(int[] arr, int n){
        boolean swapped;
        int temp = 0;
        for(int i=0; i<n-1; i++){
            swapped = false;
            for(int j=0; j<n-i-1; j++){
                if(arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped) break;
        }
    }
    
    public static void main(String[] args) throws Exception {
        int arr[] = {4,1,3,2,7,5,6};
        bubbleSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}



/*
      O U T P U T
      [1, 2, 3, 4, 5, 6, 7]
*/

/*
      T I M E - C O M P L E X I T Y
      
      Worst and Average Case Time Complexity: O(n*n). Worst case occurs when array is reverse sorted.

      Best Case Time Complexity: O(n). Best case occurs when array is already sorted.

      Auxiliary Space: O(1)
*/
