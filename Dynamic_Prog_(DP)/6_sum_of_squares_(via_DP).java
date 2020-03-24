
public class Main{
    
    public static int findMin(int a, int b){ return a<b?a:b; }
    
    public static int count(int n){
        int store[] = new int[n+1];
        store[1]=1;
        for(int i=2; i<=n; i++){
            int min = i;   // using 1^2 only
            for(int j=1; j*j<=i ; j++){     // perfect square + remaining
                min = findMin(min, store[i-j*j]+1);  // renmaining ans = store[i-j*j]   and  perfectSq ans = 1
            }
            store[i] = min;     // min of both is set to store[i]
        }
        return store[n];
    }
    
    public static void main(String[] args){
        System.out.println(count(10));
    }
}

// ans = 3 (9+1 == 3^2 + 1^2 == perfectSq + remaining)
