/*

    Question:-  to find min number of integers required whose sum of squares is equal to num(say 10) 

*/

import java.lang.Math;

public class Main
{
    
    public static int rooter(double n){
        return (int)Math.sqrt(n);
    }
    
    public static int sqSum(int n){
        
        // B A S E  C A S E 
        
        if(n<=0)
            return 0;
        
        /*
            for i=starting point.....
            
            (i=1)   10 = (1^2) + (10 - (1^2))  =  1 + {9}
            (i=2)   10 = (2^2) + (10 - (2^2))  =  4 + {6}
            (i=3)   10 = (3^2) + (10 - (3^2))  =  9 + {1}
            
            hence i will move till sqrt(10)
            
            note:- since our function is returning min num of integers hence....
            
            op1 = 1 way(for 1^1) + {min of rest {9}}
            op2 = 1 way(for 2^2) + {min of rest {4}}
            op3 = 1 way(for 3^3) + {min of rest {1}}
            
            return min of all the opts
        */
            
        int numOfOpts = rooter(n);
        int minSol = -1;
        for(int i=1; i<=numOfOpts; i++){
            
            int temp = 1 + sqSum(n-(i*i)); 
            if(temp<minSol || minSol==-1)
                minSol = temp;
        }
        return minSol;
    }
    
	public static void main(String[] args) {
        System.out.println("min integers req are: \t" + sqSum(10));		
	}
}
