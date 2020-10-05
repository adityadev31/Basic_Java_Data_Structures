/* ---------Q U I C K  -  S O R T ------------*/


import java.util.*;

public class Main {
    
    public static void swap(int[] arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    
    public static int partition(int[] arr, int l, int r){
        int p = r;
        int i = l-1;
        int j = l;
        while(j < p){
            if(arr[j]<arr[p]){
                i++;
                swap(arr, i, j);
            }
            j++;
        }
        i++;
        swap(arr, i, p);
        return i;
    }
    
    public static void quickSort(int[] arr, int l, int r){
        if(l>=r) return;
        int p = partition(arr, l, r);
        quickSort(arr, l, p-1);
        quickSort(arr, p+1, r);
    }
    
    public static void main(String[] args) throws Exception {
        int arr[] = {4,1,3,2,7,5,6};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}


/* 
        O U T P U T
        
        [1, 2, 3, 4, 5, 6, 7]
*/

/*  
        T I M E  - C O M P L E X I T Y
        
        Time Complexity: 
        worst case would occur when the array is already sorted in increasing or decreasing order O(n2)
        The best case occurs when the partition process always picks the middle element as pivot. O(n*logn)
        Average Case:   O(n*logn)

        Auxiliary Space: O(1)
*/
