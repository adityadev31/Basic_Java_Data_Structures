import java.util.*;

public class Main{


    public static ArrayList<Boolean> isPrime(int num){
        ArrayList<Boolean> primesList = new ArrayList<>();
        for(int i=0; i<=num; i++){
            int flag = 1;
            for(int j=2; j*j<=i; j++){
                if(i<2){
                    primesList.add(false);
                    flag = 0;
                    break;
                }
                else if(i==2){
                    flag = 0;
                    primesList.add(true);
                    break;
                }
                else if(i%j == 0){
                    flag = 0;
                    break;
                }
            }
            if(flag != 0){
                primesList.add(true);
            }
            else    
                primesList.add(false);
        }
        return primesList;
    }


    public static ArrayList<Integer> primeFactor(int num){
        ArrayList<Boolean> prime = isPrime(num);
        ArrayList<Integer> ans = new ArrayList<>();
        int rem = num;
        int i=2;
        while(i<=num && rem!=1){
            if(rem%i == 0 && prime.get(i) == true){
                ans.add(i);
                rem = rem/i;
            }
            else{ i++; }
        }
        return ans;
    }


    public static void main (String[] args) {
        int num = 102;
        ArrayList<Integer> ans = primeFactor(num);
        System.out.print(ans);
    }
    
    
}
