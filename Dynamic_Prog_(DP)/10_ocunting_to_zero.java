/*
You are given queries. Each query consists of a single number n. You can perform any of the 2 operations on in each move:

1: If we take 2 integers a and b where n=(a x b), where a!=1 b!=1 , then we can change n = max(a, b)

2: Decrease the value of n by 1.

Determine the minimum number of moves required to reduce the value of n to 0.

*/

import java.util.*;

public class Main {
    
    
    public static int findSteps(int n){
        int store[] = new int[n+1];
        store[0] = 0;
        store[1] = 1;
        for(int i=2; i<=n; i++){
            // option 1
            int op1 = store[i-1]+1;
            
            // option 2
            int min = Integer.MAX_VALUE;
            for(int j=2; j<=i/2; j++){
                for(int k=2; k<=i/2; k++){
                    if(j*k==i){
                        int x = j>k?j:k;
                        min = x<min?x:min;
                    }
                }
            }
            if(min<=n){
                int op2 = store[min]+1;
                store[i] = op1<op2?op1:op2;
            }
            else{ store[i] = op1; }
        }return store[n];
    }
    
    
    public static void main(String[] args) throws Exception {
        int num = 4;
        System.out.println("Steps for "+num+" = "+findSteps(num));
    }
}


// output - Steps for 4 = 3
