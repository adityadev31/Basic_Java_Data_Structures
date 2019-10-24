class RedCheck{
    
    int top, size;
    char arr[];
    
    // constructor
    RedCheck(String str){
        size = str.length();
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
    
    
    // check parenthesis
    boolean isMatching(String ex){
        for(int i=0; i<size; i++){
            if(ex.charAt(i)=='(')
                push(ex.charAt(i));
                
            else if(ex.charAt(i)==')')
                pop();
        }
        if(top == -1)
            return true;
        return false;
    }
    
}



public class Main{

     public static void main(String []args){
        
        String str = "((a+b)+(c))";
        RedCheck ob = new RedCheck(str);
        boolean result = ob.isMatching(str);
        
        if(result == true)
            System.out.println("Parenthesis matched !!");
        else
            System.out.println("Parenthesis not matching !!");
     }
}
