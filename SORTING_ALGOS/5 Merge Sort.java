import java.util.*;

public class Main {
    
    public static void merge(int[] arr, int l, int m, int r){
        int n1 = m-l+1;
        int n2 = r-m;
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];
        for(int i=0; i<n1; i++) arr1[i] = arr[l+i];
        for(int i=0; i<n2; i++) arr2[i] = arr[m+1+i];
        int i=0, j=0, k=l;
        while(i<n1 && j<n2){
            if(arr1[i] < arr2[j]) arr[k++] = arr1[i++];
            else arr[k++] = arr2[j++];
        }
        while(i<n1) arr[k++] = arr1[i++];
        while(j<n2) arr[k++] = arr2[j++];
    }
    
    public static void mergeSort(int[] arr, int l, int r){
        if(l>=r) return;
        int m = (l+r)/2;
        mergeSort(arr, l, m);
        mergeSort(arr, m+1, r);
        merge(arr, l, m, r);
    }
    
    public static void main(String[] args) throws Exception {
        int arr[] = {4,1,3,2,7,5,6};
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}



/*

OUTPUT

[1, 2, 3, 4, 5, 6, 7]

*/


/*
            T I M E   C O M P L E X I T I E S
            
            Worst Case Time Complexity [ Big-O ]: O(n*log n)

            Best Case Time Complexity [Big-omega]: O(n*log n)

            Average Time Complexity [Big-theta]: O(n*log n)

            Space Complexity: O(n)

*/
