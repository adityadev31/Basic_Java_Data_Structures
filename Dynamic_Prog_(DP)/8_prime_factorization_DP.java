import java.lang.Math;
import java.util.*;

public class Main{
    
    
    public static boolean[] primes(int num){    // prime no. = true else false (from i=0, i<= num)
        
        boolean storage[] = new boolean[num + 1];
        
        for(int i=0; i<=num; i++){
            int flag = 1;
            for(int j=2; j*j<=i; j++){
                
                if(i<2){
                    storage[i] = false;
                    flag = 0;
                    break;
                }
                else if(i == 2){
                    storage[i] = true;
                    flag = 0;
                    break;
                }
                else if(i%j == 0){
                    flag = 0;
                    break;
                }
            }
            if(flag != 0){
                storage[i] = true;
            }
        }
        return storage;
    }
    
    
    public static ArrayList<Integer> primeFact(int num){    // check only till {sqrt(num)+1} (+ 1 is to be in safe side)
        ArrayList<Integer> ans = new ArrayList<>();
        boolean primes[] = primes(num);
        int rem = num;
        while(rem != 1){
            int j=2;
            while(j <= num){
                if(rem%j == 0 && primes[j] == true){
                    rem = rem/j;
                    ans.add(j);
                }
                else
                    j++;
            }
            if(j>num && rem!=1){
                rem = 1;
                ans.add(num);
            }
        }
        return ans;
    }
    
    
    public static void main(String args[]){
        int num = 376;
        ArrayList<Integer> ans = primeFact(num);
        System.out.print(ans);
    }
    
}
