class RedCheck{
    
    int top, size;
    String eq;
    char arr[];
    
    // constructor
    RedCheck(String str){
        eq = str;
        size = eq.length();
        top = -1;
        arr = new char[size];
    }
    
    // push
    void push(char x){
        if(top != size-1){
            top++;
            arr[top] = x;
        }
    }
    
    
    // pop
    void pop(){
        if(top != -1)
            top--;
    }
    
    
    // print
    void print(){
        for(int i=0; i<=top; i++){
            System.out.print(arr[i] + " ");
        }
    }
    
    
    // check redundancy
    boolean redundancyCheck(String expr){
        for(int i=0; i<size; i++){
            int flag = 0;
            if(expr.charAt(i)!=')'){
                push(expr.charAt(i));
            }
            else{
                while(arr[top]!='('){
                    if(arr[top]=='+' || arr[top]=='-' || arr[top]=='*' || arr[top]=='/')
                        flag = 1;
                    pop();
                }pop();
                if(flag == 0)
                    return false;
            }
        }
        return true;
    }
    
}



public class Main{

     public static void main(String []args){
        
        String str = "((a+b)+(c))";
        RedCheck ob = new RedCheck(str);
        boolean result = ob.redundancyCheck(str);
        System.out.println(result);
     }
}
