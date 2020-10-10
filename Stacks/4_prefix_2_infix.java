/*

same as post2in
but instead of (op2 + op1) ==> we will be having (op1 + op2)

*/


import java.util.*;

public class Main {
    
    public static boolean isOperand(char c){
        return ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'));
    }
    
    public static String pre2in(String exp){
        
        StringBuilder sb = new StringBuilder(exp);
        exp = sb.reverse().toString();
        char[] c = exp.toCharArray();
        Stack<String> st = new Stack<>();
        
        for(int i=0; i<c.length; i++){
            
            // ==== step1 ====== operand
            if(isOperand(c[i])) st.push(c[i] + "");
            
            // ==== step2 ====== operator
            else{
                String op1 = st.pop();
                String op2 = st.pop();
                st.push("(" + op1 + c[i] + op2 + ")");   // same as post2in but (op1 + op2)
            }
        }
        return st.peek();
    }
    
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String ip = scan.nextLine();
        System.out.println(pre2in(ip));
    }
}


/*
    prefix => *+AB-CD
    infix  => ((A+B)*(C-D))
*/
