public class Main
{
    /*************************************
     * (normal way)
     * 
    public static int fibo(int n){
        if(n==0 || n==1)
            return n;
        int small = fibo(n-1) + fibo(n-2);
        return small;
    }
    **************************************/
    
    
    // D P //
    
    public static int fibo(int n){        // say for fibo(4) we need fibo(4), fibo(3), 2, 1, 0
        int storage[] = new int[n+1];     // hence make an empty array of size = n+1 to store values
        for(int i=0; i<n+1; i++){
            storage[i] = -1;              // set each value = -1
        }
        return fibo(n, storage);          // send n and storage array to another fibo(int , int[])
    }
    
    
    /****
    step-1 :- check for storage (if not present then store)
    step-2 :- return the stored value
    *****/
	
	
    public static int fibo(int n, int storage[]){ // strategy -> if values are already present in storage then no need to call the function
        if(n==0 || n==1){                         // B A S E  C A S E 
            storage[n] = n;                   // put value in storage
            return storage[n];                    // return the stored value
        }
        if(storage[n]==-1)                    		          // check if present in array or not
            storage[n] = fibo(n-1, storage)+fibo(n-2, storage);   // if not then store
        return storage[n];                                        // return the stored value
    }
    
	public static void main(String[] args) {
		System.out.println(fibo(55));         // O(n)
	}
}
