import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] bookArray = new String[5][3];
        
        // getting array
        for(int i=0; i<bookArray.length; i++) {
            for(int j=0; j<bookArray[0].length; j++) {
                bookArray[i][j] = br.readLine().trim();
            }
        }
        
        // sort according to id
        Arrays.sort(bookArray, (a, b) -> Integer.parseInt(a[0]) - Integer.parseInt(b[0]));  // using lambda function
        
        // print array
        for(String[] row: bookArray) {
            System.out.printf("%-10s %-30s %-30s\n",row[0],row[1],row[2]);
        }
    }
}


/*
Input:

108
The Complete Reference
Herbert Schildt
104
Angular 8
Jeffry Houser
101
Head First Java
Kathy Sierra
105
React
Robin Wieruch
102
Servlet Programming
Jason Hunter

*/

/*

Output:

101        Head First Java                Kathy Sierra                  
102        Servlet Programming            Jason Hunter                  
104        Angular 8                      Jeffry Houser                 
105        React                          Robin Wieruch                 
108        The Complete Reference         Herbert Schildt

*/




/* USING COMPARATOR 

Arrays.sort(array, new Comparator<String[]>() {
    public int compare(String[] a, String[] b) {
        return a[0].compareTo(b[0]);
    }
});

*/
