/*

    we have to make 2 subsets of an array such that the absolute of their difference = minimum
    
    NOTE - if S1 = S2 then difference = 0 (for this, s1 = sum of all the elements of the original array)
    
    so :-
    
    step1 - sum = sum of all elements
    step2 - find sum of subset with (sumForS1 = sum/2)
    step3 - collect all s1[n][0 to sumForS1] == true cases in an ArrayList
    step4 - NOTE - the last element of ArrayList = required S1
    step5 - S2 = (sum - S1)
    step6 - ans = (S2 - S1)

*/


import java.util.ArrayList;
class Main{
    
    public static int findSum(int[] arr){
        int sum = 0;
        for(int i=0; i<arr.length; i++){ sum += arr[i]; }
        return sum;
    }
    
    public static int ans(int[] arr, int sum, int n, boolean[][] store){
        ArrayList<Integer> alist = new ArrayList<>();
        for(int i=1; i<=n; i++){
            for(int j=1; j<=sum; j++){
                if(arr[i-1]>j){ store[i][j] = store[i-1][j]; }
                else{
                    boolean op1 = store[i-1][j];
                    boolean op2 = store[i-1][j-arr[i-1]];
                    if(op1==true || op2==true){ store[i][j] = true; }
                    else{ store[i][j] = false; }
                }
            }
        }
        for(int j=0; j<=sum; j++){ if(store[n][j]==true){ alist.add(j); } }
        return alist.get(alist.size()-1);
    }
    
    public static int ans(int[] arr, int sum, int n){
        boolean[][] store = new boolean[n+1][sum+1];
        for(int j=0; j<=sum; j++){ store[0][j] = false; }
        for(int i=0; i<=n; i++){ store[i][0] = true; }
        return ans(arr, sum, n, store);
    }
    
    public static void main (String[] args) {
        int[] arr = {1,7,2};
        int sum = findSum(arr);
        int s1 = ans(arr, sum/2, arr.length);
        int s2 = sum - s1;
        int ans = s2 - s1;
        System.out.println("ans = " + ans);
    }
    
}


/*
    ans = 4   s1={1,2}  s2={7}
*/
