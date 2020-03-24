

public class Main{
    
    public static int findMin(int a, int b){
        int x= a<b?a:b;
        return x;
    }
    
    public static int count(int n){
        int store[] = new int[n+1];
        store[1] = 1;
        for(int i=2; i<=n; i++){
            store[i] = i;           // using only 1
            int min = store[i];
            for(int j=1; j*j<=i; j++){ // ex - n = 30 then we need 25+5 = 5^2 + 2^2 + 1^2 = 3
                store[i] = store[i-j*j]+1;
                min = findMin(min, store[i]);
                store[i] = min;
            }
        }return store[n];
    }
    
    public static void main(String[] args){
        System.out.println(count(14));          // 14=9+5== 3^2 + 2^2 + 1^2 == 1step + 2step
    }
}
