import java.util.*;


class Heap{
    
    private int[] arr;
    
    Heap(int[] x){              // constructor
        arr = x;
        sort(arr);          // calling sort
    }
    
    private void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    
    private void sort(int[] arr){
        int n = arr.length;
        maxHeap(arr, n);                // step1 - making max heap
        for(int i=n-1; i>=0; i--){      // step2 - pushing max element to the end and heapify again
            swap(arr, i, 0);
            heapify(arr, i, 0);         // end=i  start=0
        }
    }
    
    
    // M A X   H E A P
    private void maxHeap(int[] arr, int n){
        for(int i=n/2-1; i>=0; i--) heapify(arr, n, i);  // end=n  start=i
    }
    
    
    // H E A P I F Y 
    private void heapify(int[] arr, int n, int i){
        int largest = i;                               // max = i
        int l = 2*i+1;
        int r = 2*i+2;
        if(l<n && arr[l] > arr[largest]) largest = l;  // max = l
        if(r<n && arr[r] > arr[largest]) largest = r;  // max = r
        if(largest != i){
            swap(arr, largest, i);
            heapify(arr, n, largest);                  // end=n  start=largest
        }
    }
}


public class Main {
    public static void main(String[] args) throws Exception {
        int[] arr = {4,1,5,3,7,6,2};
        Heap heap = new Heap(arr);
        for(int x: arr) System.out.print(x + " ");
    }
}

// ans  - 1 2 3 4 5 6 7
