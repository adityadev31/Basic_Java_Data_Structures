public class Main{
    
    public static int count(int n){
        int storage[] = new int[n+1];
        for(int i=2; i<=n; i++){
            int min = storage[i-1];
            if(i%2==0){
                int op2 = storage[i/2];
                if(op2<min){min=op2;}
            }
            if(i%3==0){
                int op3 = storage[i/3];
                if(op3<min){min=op3;}
            }
            storage[i] = min+1;
        }
        return storage[n];
    }
    
    public static void main(String[] args){
        int num=100;
        System.out.println(count(num));
    }
}
