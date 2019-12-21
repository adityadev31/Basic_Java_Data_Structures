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
    
    public static int fibo(int n){
        int storage[] = new int[n+1];
        for(int i=0; i<n+1; i++){
            storage[i] = -1;
        }
        return fibo(n, storage);
    }
    
    
    public static int fibo(int n, int storage[]){
        if(n==0 || n==1){
            if(storage[n]==-1)
                storage[n] = n;
            return storage[n];
        }
        if(storage[n]==-1)
            storage[n] = fibo(n-1, storage)+fibo(n-2, storage);
        return storage[n];
    }
    
	public static void main(String[] args) {
		System.out.println(fibo(55));
	}
}
