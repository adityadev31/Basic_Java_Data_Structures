import java.util.*;

// fill 2D array

public class Main {
    public static void main(String[] args) throws Exception {
        int[][] arr = new int[5][5];
        
        Arrays.stream(arr).forEach(a -> Arrays.fill(a, 10));    // for each row 'a' -> fill 'a' with 10
        
        // print array
        System.out.println(Arrays.deepToString(arr));
    }
}


/*
  output
  [[10, 10, 10, 10, 10], [10, 10, 10, 10, 10], [10, 10, 10, 10, 10], [10, 10, 10, 10, 10], [10, 10, 10, 10, 10]]
*/
