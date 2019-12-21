public class Main{
    
    
   /*
    *        in D P recursion should not be used 
    *        so iterative method should be used
    *
    */
    
    public static int fibo(int n){
        if(n==0 || n==1)
            return n;
            
        int storage[] = new int[n + 1];  // coz if n=4 then we need 4, 3, 2, 1, 0
        storage[0] = 0;
        storage[1] = 1;
        for(int i=2; i<=n; i++){
            storage[i] = storage[i-1] + storage[i-2];
        }
        return storage[n];
    }
    
    
    public static void main(String args[]){
        int n = 2;
        System.out.println(fibo(n));
    }
    
}
