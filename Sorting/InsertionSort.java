import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        int arr[] = {3,2,5,4,1};
        
        // [2,3,5],4,1     we will sort such that left part is sorted 
        
        if(arr.length>1){
            int n = arr.length;
            if(n>1){
                for(int i=1; i<n; i++){
                    int temp = arr[i];
                    int j=i-1;
                    while(j>=0 && arr[j]>arr[i]){ j--; }    // finding the first smaller value from right to left
                    j++;                                    // finally j will become one less hence j++
                    int mover = i;
                    while(mover>j){
                        arr[mover] = arr[mover-1];
                        mover--;
                    }
                    arr[j] = temp;
                }
            }
        }
        
        for(int i=0; i<arr.length; i++){ System.out.print(arr[i] + " "); }
    }
}
