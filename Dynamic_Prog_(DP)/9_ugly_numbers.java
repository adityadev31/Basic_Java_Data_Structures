/*
  Ugly numbers are numbers whose only prime factors are 2, 3 or 5. The sequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … shows the first 11 ugly numbers. By convention, 1 is included.

  Given a number n, the task is to find n’th Ugly number.
*/

public class Main{
    
    public static int ugly(int count){
        int store[] = new int[count+1];
        store[0] = -1;
        store[1] = 1;
        int i=2, j=2;
        while(i<=count){
            int num = j;
            while(true){
                if(num%2==0){num/=2;}
                else{break;}
            }
            while(true){
                if(num%3==0){num/=3;}
                else{break;}
            }
            while(true){
                if(num%5==0){num/=5;}
                else{break;}
            }
            if(num==1){store[i++]=j;}
            j++;
        }return store[count];
    }
    
    public static void main(String[] args){
        System.out.println(ugly(10));
    }
}

// output = 12 for 10
