class MergeSort{


	void merge(int arr[], int l, int m, int r){
		int n1 = m-l+1;    								 // creating helper array1 of length till mid (m-l+1)
		int n2 = r-m;       							 // creating 2nd array of length mid+1 to r (r-m)
		int arr1[] = new int[n1];
		int arr2[] = new int[n2];
		
		for(int i=0; i<n1; i++){     // copying l to m in arr1
			arr1[i] = arr[l+i];
		}
		for(int i=0; i<n2; i++){     // copying l to m in arr1
			arr2[i] = arr[m+1+i];
		}
		
		int i=0, j=0, k=l;
		
		while(i<n1 && j<n2){               // till either i=n1 or j=n2
			if(arr1[i]<arr2[j])            // smaller will be copied to the original array
				arr[k++] = arr1[i++];      // and smaller and original indexes are incremented
			else
				arr[k++] = arr2[j++];
		}
		
		while(i<n1){						// copying the rest of the array (if left)
			arr[k++] = arr1[i++];
		}
		while(j<n2){						// copying the rest of the array (if left)
			arr[k++] = arr2[j++];
		}
				
	}


	void divide(int arr[], int l, int r){
		if(l>=r)                
			return;				// recursion base case
			
		int m = (l+r)/2;        // middle point of (l and r)
		divide(arr, l, m);      // 1st half
		divide(arr, m+1, r);	// 2nd half
		merge(arr, l, m, r);	// merging 1st and 2nd
	}
	
	
	void print(int arr[]){
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i] + " ");
		}
	}

}


public class Main{
	public static void main(String args[]){
		int arr[] = {1, 6, 3, 5, 2, 4};
		MergeSort ob = new MergeSort();
		ob.divide(arr, 0, arr.length-1);
		ob.print(arr);
	}
}
