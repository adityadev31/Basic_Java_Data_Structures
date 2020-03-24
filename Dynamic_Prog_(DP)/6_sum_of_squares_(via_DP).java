
/***

        STRATEGY:-   if say num = 10  ->  1, 4, 9  can be used hence  number of opts are [sqrt(num)] here opt = 3
        
        step 1-   array storage[opts+1] = {0, 1, 4, 9}
        
        step 2-   int count, int remaining=n,  int i=opt {coz we will move from right to left of the array till remaining = 0}
        
        step 3-   while(remain != 0){
            
            step 4 -    we will check if storage[i] <= remaining
            step 5 -    if(no then i--)
            step 6 -    if(yes then) -->  count++;  remaining = remaining - (storage[i]);    break;
                        
                        i.e, remaining = 10 - 9   (for i=opt)
                        i.e, count  =  1;
                        i.e, break; (i will still remain = current i)
            
            step 7 -    next iteration (i = 3) and remaining = 1
            step 8 -    now loop till storage[i] <= 1
            step 9 -    count++  = 2;  break;
        }
        
***/



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
