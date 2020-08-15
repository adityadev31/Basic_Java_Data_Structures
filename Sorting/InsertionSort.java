import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        int arr[] = {3,2,5,4,1};
        
        // [2,3,5],4,1     we will sort such that left part is sorted 
        
        for(int i=1; i<n; i++){              // i= 1 --> n
            int temp = arr[i];               // temp = arr[i]
            int j=i-1;                       // j = i-1
            while(j>=0 && arr[j]>temp){      // j --> 0 && arr[j] > temp
                arr[j+1] = arr[j];           // keep shifting j --> j+1 
                j--;
            }
            arr[j+1] = temp;                 // at the end j+1 = temp
        }
        
        for(int x: arr) System.out.print(x+" ");
    }
}


/**

step1 - [3 2 5 4 1]

step2 - [3] 2 5 4 1    arr[i]=2  arr[j]=3    temp = [2]   --> 3>2 so right shift 3

step3 - [] 3 5 4 1     now j<0 so j+1 = temp   -->  [2 3] 5 4 1

step4 - [2 3] 5 4 1    arr[i]=5  arr[j]=3    temp = [5]

step5 - [2 3 5] 4 1    since 3<5  j+1=temp;

step6 - [2 3 5] 4 1    arr[i]=4  arr[j]=5    temp = [4]

step7 - [2 3 []] 5 1   since 5>temp=4

step8 - [2 3 4 5] 1    since 3<temp=4  --> j+1=4   now temp = [1]

step9 - [2 3 4 []] 5   since arr[j]>temp

step10 - [2 3 [] 4] 5   since arr[j]>temp

step11 - [2 [] 3 4] 5   since arr[j]>temp

step12 - [[] 2 3 4] 5   since arr[j]>temp

step13 - [1 2 3 4 5]   since j < 0

**/

// 1 2 3 4 5 
