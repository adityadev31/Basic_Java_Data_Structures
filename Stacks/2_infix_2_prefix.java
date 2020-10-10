
/*

same as infix -> postfix

step1 => reverse the expression
step2 => apply infix -> postfix [ ')' => push  '(' => pops ]  reverse of prefix
step3 => reverse the result


*/





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
    
    public static String postfix(String exp){
        StringBuilder sb = new StringBuilder();
        char c[] = sb.append(exp).reverse().toString().toCharArray();
        Stack<Character> st = new Stack<>();
        String result = "";
        
        for(int i=0; i<c.length; i++){
            
            // ====== step1 ========  operator
            if(precedence(c[i])>0){
                while(!st.empty() && precedence(st.peek())>=precedence(c[i])) result += st.pop();
                st.push(c[i]);
            }
            
            // ====== step2 ======== )
            else if(c[i] == ')') st.push(c[i]);
            
            // ====== step3 ======== (
            else if(c[i] == '('){
                while(!st.empty() && st.peek()!=')') result += st.pop();
                st.pop();
            }
            
            // ====== step4 ======== alphabets
            else result += c[i];
            
        }
        
        while(!st.empty()) result += st.pop();
        sb = new StringBuilder(result);
        result = sb.reverse().toString();
        return result;
    }
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String exp = scan.nextLine();
        System.out.println(postfix(exp));
    }
    
}


/*

    input  => (a-b/c)*(a/k-l) 
    output => *-a/bc-/akl

*/
