/*
 *   Question - to find min number of steps to go from a number 'n' to 1 by peforming (n-1) or (n/2) or (n/3)
 */


public class Main{
    
    public static int findMin(int a, int b){ return a<b?a:b; }
    
    public static int count(int n){
        int storage[] = new int[n+1];
        for(int i=2; i<=n; i++){
            
            int min = storage[i-1];                           // option1
            if(i%2==0){ min = findMin(min, storage[i/2]); }   // option2
            if(i%3==0){ min = findMin(min, storage[i/3]); }   // option3
            
            storage[i] = min+1;    // setting storage[i]
        } return storage[n];
    }
    
    public static void main(String[] args){
        System.out.println(count(11));
    }
}


// ans = 4
