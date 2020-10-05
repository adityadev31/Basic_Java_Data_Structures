/* ---------I N S E R T I O N  -  S O R T ------------*/


import java.util.*;

public class Main {
    
    public static void insertionSort(int[] arr, int n){
        int temp = 0, j = 1;
        for(int i=1; i<n; i++){
            j = i;
            temp = arr[i];
            while(j > 0 && arr[j-1] > temp){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
        }
    }
    
    public static void main(String[] args) throws Exception {
        int arr[] = {4,1,3,2,7,5,6};
        insertionSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}


/* 
        O U T P U T
        
        [1, 2, 3, 4, 5, 6, 7]
*/

/*  
        T I M E  - C O M P L E X I T Y
        
        Time Complexity: O(n*2)

        Auxiliary Space: O(1)
*/
