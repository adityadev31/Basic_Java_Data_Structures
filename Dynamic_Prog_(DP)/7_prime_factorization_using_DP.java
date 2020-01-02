
/*
 * 
 *          P R I M E   F A C T O R I Z A T I O N   U S I N G   D P
 * 
 */


public class Main
{
    
    public static int[] findPrimes(int x){    // function to find all the prime nos. <= num, and store it in the array of length num+1
        
        int primes[] = new int[x+1];
        int count = 1;
        
        primes[0] = 1;
        primes[1] = 1;
        
        for(int i=2; i<=x; i++){
            int flag = 1;
            for(int j=2; j*j<=i; j++){
                if(i%j == 0){
                    flag = 0;
                    break;
                }
            }
            if(flag != 0)
                primes[++count] = i;
        }
        while(count != x){
            if(primes[count] == -1)
                primes[++count] = -1;
            else    
                primes[++count] = x;
        }
        return primes;                      // primes[] = {1,1,2,3,5,7,11,13,17,19,20,20,20...till i=20}
    }
    
    public static void primeFact(int num){    // function to find prime factorizations
        int primes[] = findPrimes(num);
        int rem = num;
        while(rem != 1){
            for(int i=2; i<primes.length; i++){     // starting with i=2
                if(rem % primes[i] == 0){
                    rem /= primes[i];
                    System.out.print(primes[i] + " ");
                    i++;
                    break;
                }
                if(primes[i] == primes[i-1] || i == primes.length-1){   // if nothing match then use num i.e, 20 itself
                    rem = 1;
                    System.out.print(primes[i] + " ");
                    break;
                }
            }
        }
    }
    
    
	public static void main(String[] args) {
	    int num = 20;
		System.out.print("Prime Fact of " + num + " is:   ");
		primeFact(num);
	}
}
