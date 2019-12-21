/*
 *   Question - to find min number of steps to go from a number 'n' to 1 by peforming (n-1) or (n/2) or (n/3)
 */


public class Main{
    
    public static int count2one(int n){
        if(n<=1)
            return 0;
            
        int op1 = count2one(n-1);              // option 1
        int minCounts = 1 + op1;
        
        if(n % 3 == 0){                        // option 2
            int op2 = 1 + count2one(n/3);
            if(op2<minCounts)
                minCounts = op2;
        }
        
        if(n % 2 == 0){                        // option 3
            int op3 = 1 + count2one(n/2);
            if(op3<minCounts)
                minCounts = op3;
        }
        
        return minCounts;
    }
    
    public static void main(String args[]){
        System.out.println(count2one(10));
    }
}
