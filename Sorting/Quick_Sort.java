class QuickSort{
    
    void swap(int arr[], int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    
    
    int partition(int arr[], int l, int r){
        int pivot = r;
        int i = l-1;                    // behind l
        int j = l;                      // stating from l 
        
        for(j=l; j<r; j++){                  
            if(arr[j]<arr[pivot]){           // when smaller element is found -> swap otherwise j++ only
                i++;
                swap(arr, i, j);
            }
        }
        i++;
        swap(arr, i, pivot);       // swapping pivot with the 1st greater element found (i.e, at i+1 coz till i all are smaller than pivot)
        return i;
    }
    
    
    void quick(int arr[], int l, int r){
        if(l>=r)
            return;                             // base case 
            
        int p = partition(arr, l, r);           // finding partition (setting pivot)
        quick(arr, l, p-1);                     // recursive call quick partition
        quick(arr, p+1, r);
    }
}

public class Main{

    public static void print(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
    
    public static void main(String args[]){
        int A[] = {6, 2, 4, 1, 3, 5, 2, 4};
        
        QuickSort ob = new QuickSort();
        ob.quick(A, 0, A.length-1);
        print(A);
    }
}
