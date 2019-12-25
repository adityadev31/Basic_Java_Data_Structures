
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



import java.lang.Math;

public class Main
{
    public static int sumOfSquares(int n){
        int opts = (int)Math.sqrt(n);
        int storage[] = new int[opts+1];
        for(int i=0; i<=opts; i++){
            storage[i] = (i*i);
        }
        return sumOfSquares(n, storage, opts);
    }
    
    
    public static int sumOfSquares(int n, int storage[], int opts){
        int count = 0;
        int i = opts;
        int remaining = n;
        while(remaining!=0){
            for(i=i; i>=0; i--){
                if(storage[i]<=remaining){
                    count++;
                    remaining = remaining - storage[i];   // if i = 5 here
                    break;
                }
            }               
                            // then i is also 5 here
        }
        return count;
    }
    
    
	public static void main(String[] args) {
		System.out.println("min num are:\t" + sumOfSquares(30));
	}
}
