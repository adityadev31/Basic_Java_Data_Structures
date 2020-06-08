/**

quest - to find the no. of ways to make the expression true or false

using the same format of MCM

**/



import java.util.*;

public class Main{
    
    public static int solve(String str, int i, int j, boolean isTrue){
        // base case
        if(i>j){ return 1; }
        if(i==j){
            if(isTrue==true)
                return (str.charAt(i)=='T') ? 1:0;
            else
                return (str.charAt(i)=='F') ? 1:0;
        }
        
        // choice case
        int ans = 0;
        for(int k=i+1; k<=j-1; k=k+2){
        
            int lt = solve(str, i, k-1, true);          // finding left right possibilities
            int lf = solve(str, i, k-1, false);
            int rt = solve(str, k+1, j, true);
            int rf = solve(str, k+1, j, false);
            
            if(str.charAt(k)=='&'){
                if(isTrue==true){ ans = ans + (lt*rt); }          // TT = T
                else{ ans = ans + (lt*rf) + (lf*rt) + (lf*rf); }  // TF=F  FT=F  FF=F
            }
            
            if(str.charAt(k)=='|'){
                if(str.charAt(k)=='|'){ ans = ans + (lt*rf) + (lf*rt) + (lt*rt); }   // TF=T  FT=T  TT=T
                else{ ans = ans + (lf*rf); }                                         // FF=F
            }
            
            if(str.charAt(k)=='^'){
                if(str.charAt(k)=='^'){ ans = ans + (lf*rt) + (lt*rf); }     // FT=T  TF=T
                else{ ans = ans + (lt*rt) + (lf*rf); }                       // FF=F  TT=F
            }
            
        }
        return ans;
    }
    
    public static void main(String args[]){
        String str = "T|F&T^F";
        System.out.println("No of ways:- " + solve(str, 0, str.length()-1, true));
    }
    
}

// ans = 5
