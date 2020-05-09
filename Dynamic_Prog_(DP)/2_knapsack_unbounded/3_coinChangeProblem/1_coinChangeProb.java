/*

    question- given coin array[] and a sum no. 
    we have to find the no. of ways we can combine coins given in the array 
    so that their sum = given sum
    
    NOTE - multiple occurances are allowed hence unbounded knapsack problem

*/

public class Main{
    
    public static int coinProb(int[] coins, int sum, int n, int[][] store){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=sum; j++){
                if(coins[i-1]>j){ store[i][j] = store[i-1][j]; }           // current coin > sum hence rejected (i.e. i-1)
                else{
                    store[i][j] = store[i][j-coins[i-1]] + store[i-1][j];  // selected + rejected (NOTE- we have to find total ways)
                }
            }
        }return store[n][sum];
    }
    
    public static int coinProb(int[] coins, int sum, int n){
        int store[][] = new int[n+1][sum+1];
        for(int j=0; j<=sum; j++){ store[0][j] = 0; }    // if sum=0 then always their is a way (i.e. empty set hence 1)
        for(int i=0; i<=n; i++){ store[i][0] = 1; }      // if there is no coin then there's no way (i.e. 0)
        return coinProb(coins, sum, n, store);
    }
    
    public static void main(String[] args){
        int[] coins = {1,2,3};
        int sum = 5;
        System.out.println("Ans = " + coinProb(coins, sum, coins.length));
    }
    
}

/*

 ans = 5 
 
 way1 = 1+1+1+1+1
 way2 = 1+1+1+2
 way3 = 1+1+3
 way4 = 1+2+2
 way5 = 2+3

*/
