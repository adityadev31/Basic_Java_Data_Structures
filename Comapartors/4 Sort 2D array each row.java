import java.util.*;

// sort 2D array each row

public class Main {
    public static void main(String[] args) throws Exception {
        Integer[][] arr = {                             // note* => for using comparator we are taking Integer[] not int[]
            {4,2,6,5},{9,7,5,8},{3,3,1,2},{4,8,6,3}
        };
        
        // ascending sorting
        Arrays.stream(arr).forEach(a -> Arrays.sort(a));
        
        // print array
        System.out.println("Accending:\t"+Arrays.deepToString(arr));
        
        // descending sorting
        Arrays.stream(arr).forEach(a -> Arrays.sort(a, new Comparator<Integer>(){
            public int compare(Integer e1, Integer e2) { return e2-e1;}
        }));
        
        // print array
        System.out.println("Decending:\t"+Arrays.deepToString(arr));
    }
}


/*
  output
  Accending:	[[2, 4, 5, 6], [5, 7, 8, 9], [1, 2, 3, 3], [3, 4, 6, 8]]
  Decending:	[[6, 5, 4, 2], [9, 8, 7, 5], [3, 3, 2, 1], [8, 6, 4, 3]]
*/
