/*
ALGO

1) push all the elements of the expression till ')' closing bracket is found
2) if ')' is found pop till '(' opening is found also pop '('
3) meanwhile poping, also check if any operator is found or not
4) if no operator is found then the brackets are redundant  --->  exit the loop
5) if an operator is found then till then brackets are okay --->  continue the loop

LOGIC:- brackets in a balanced expression is redundant if :-
                                a) ((a+b))   
                                b) ((a))
        i.e, for an expression presence of an operator is crucial .. hence if while poping any operator is not found then --> redundant
*/

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
                    return true;
            }
        }
        return false;
    }
    
}



public class Main{

     public static void main(String []args){
        
        String str = "((a+b)+c*d)";
        RedCheck ob = new RedCheck(str);
        if(ob.redundancyCheck(str) == true)
            System.out.println("Equation is redundant !!");
        else
            System.out.println("Equation is perfect !!");
     }
}
