/***
        make diagram and try
***/

public class Main
{
    
    public static int count2one(int n){
        if(n<=1)
            return 0;
        int storage[] = new int[n + 1];             // defaults are already 0 
        for(int i=2; i<=n; i++){
            
            // part1 (n-1)
            
                                                   // temp will store the current ressult for comparision
            int temp = storage[i-1] + 1;           //  steps for(i-1) + 1_(for jumping from i to i-1)
            if(storage[i]==0 || storage[i]>temp)   // if already smaller value is present then no change in storage[i]
                storage[i] = temp;                 // otherwise change storage[i] with current value(i.e, temp)
            
            // part2 (n/2)
            
            
            if(n % 2 == 0){
                temp = storage[i/2] + 1;           // steps for (i/2) + 1_(for jumping from i to i/2)
                if(storage[i]==0 || storage[i]>temp)   // if already a greater value present then set temp as storage[i]
                    storage[i] = temp;
            }
            
            // part3 (n/3)
            
            if(n % 3 == 0){
                temp = storage[i/3] + 1;              // steps for (i/3) + 1_(for jumping from i to i/3)
                if(storage[i]==0 || storage[i]>temp)  // if already a greater value present then set temp as storage[i]
                    storage[i] = temp;
            }
        }
        return storage[n];       // return storage[10];
    }
    
    
	public static void main(String[] args) {
		System.out.println(count2one(10));
	}
}
