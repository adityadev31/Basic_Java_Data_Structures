import java.util.*;

public class Main {
    
    public static boolean isOperand(char c){
        return ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'));
    }
    
    public static String post2in(String exp){
        char[] c = exp.toCharArray();
        Stack<String> st = new Stack<>();
        for(int i=0; i<c.length; i++){
            
            // ==== step1 ====== operand
            if(isOperand(c[i])) st.push(c[i] + "");
            
            // ==== step2 ====== operator
            else{
                String op1 = st.pop();
                String op2 = st.pop();
                st.push("(" + op2 + c[i] + op1 + ")");
            }
        }
        return st.peek();
    }
    
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String ip = scan.nextLine();
        System.out.println(post2in(ip));
    }
}

/*
    input  => ab*c+
    output => ((a*b)+c)

*/




/*

import java.util.Stack;

public class PostFixToInfix {

    public String convert(String expression){

        Stack<String> stack = new Stack<>();
        for (int i = 0; i <expression.length() ; i++) {
            char c = expression.charAt(i);

            if(c=='*'||c=='/'||c=='^'||c=='+'||c=='-' ){
                String s1 = stack.pop();
                String s2 = stack.pop();
                String temp = "("+s2+c+s1+")";
                stack.push(temp);
            }else{
                stack.push(c+"");
            }
        }

        String result=stack.pop();
        return result;
    }

    public static void main(String[] args) {
        String exp = "ABC/-AK/L-*";
        System.out.println("Postfix Expression: " + exp);
        System.out.println("Infix Expression: " + new PostFixToInfix().convert(exp));
    }
}

*/
