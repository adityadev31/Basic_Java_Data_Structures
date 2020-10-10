import java.util.*;

public class Main{
    
    public static int precedence(char c){
        switch(c){
            case '+':
            case '-':
                return 1;
                
            case '*':
            case '/':
                return 2;
                
            case '^':
                return 3;
        }
        return -1;
    }
    
    public static String postfix(char[] c){
        Stack<Character> st = new Stack<>();
        String result = "";
        
        for(int i=0; i<c.length; i++){
            
            // ====== step1 ========  operator
            if(precedence(c[i])>0){
                while(!st.empty() && precedence(st.peek())>=precedence(c[i])) result += st.pop();
                st.push(c[i]);
            }
            
            // ====== step2 ======== (
            else if(c[i] == '(') st.push(c[i]);
            
            // ====== step3 ======== )
            else if(c[i] == ')'){
                while(!st.empty() && st.peek()!='(') result += st.pop();
                st.pop();
            }
            
            // ====== step4 ======== alphabets
            else result += c[i];
            
        }
        
        while(!st.empty()) result += st.pop();
        return result;
    }
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String exp = scan.nextLine();
        char[] c = exp.toCharArray();
        System.out.println(postfix(c));
    }
    
}

/*
    input  - A+B*(C^D-E)
    output - ABCD^E-*+

*/




/*


import java.util.Stack;

public class InfixToPostFix {

    static int precedence(char c){
        switch (c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    static String infixToPostFix(String expression){

        String result = "";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i <expression.length() ; i++) {
            char c = expression.charAt(i);

            //check if char is operator
            if(precedence(c)>0){
                while(stack.isEmpty()==false && precedence(stack.peek())>=precedence(c)){
                    result += stack.pop();
                }
                stack.push(c);
            }else if(c==')'){
                char x = stack.pop();
                while(x!='('){
                    result += x;
                    x = stack.pop();
                }
            }else if(c=='('){
                stack.push(c);
            }else{
                //character is neither operator nor ( 
                result += c;
            }
        }
        for (int i = 0; i <=stack.size() ; i++) {
            result += stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        String exp = "A+B*(C^D-E)";
        System.out.println("Infix Expression: " + exp);
        System.out.println("Postfix Expression: " + infixToPostFix(exp));
    }
}
*/
