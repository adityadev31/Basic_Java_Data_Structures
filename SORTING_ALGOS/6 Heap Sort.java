/* ---------H E A P  -  S O R T ------------*/


import java.util.*;

public class Main {
    
    public static void swap(int[] arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    
    public static void heapSort(int[] arr, int n){
        // maxheap
        for(int i=(n/2)-1; i>=0; i--) heapify(arr, i, n);
        // sorting
        for(int i=n-1; i>0; i--){
            swap(arr, i, 0);
            heapify(arr, 0, i);
        }
    }
    
    public static void heapify(int[] arr, int i, int n){
        int max = i;
        int l = 2*i+1;
        int r = 2*i+2;
        if(l<n && arr[max]<arr[l]) max = l;
        if(r<n && arr[max]<arr[r]) max = r;
        if(max!=i){
            swap(arr, max, i);
            heapify(arr, max, n);
        }
    }
    
    public static void main(String[] args) throws Exception {
        int arr[] = {4,1,3,2,7,5,6};
        heapSort(arr, arr.length-1);
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
        Time complexity of heapify is -->                O(Logn). 
        Time complexity of createAndBuildHeap() is --->  O(n)      and 
        overall time complexity of Heap Sort is --->     O(nLogn).
*/
