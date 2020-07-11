import java.util.*;

 // Compiler version JDK 11.0.2

 class Main
 {
   public static void main(String args[])
   { 
    int[] a = {2,5,1,4,3};
    ArrayList<Integer> list = new ArrayList<>();
    for(int x : a) list.add(x);
    
    Collections.sort(list, new Comparator<Integer>(){
      @Override
      public int compare(Integer a, Integer b){
        return b-a;       // descending
      }
    });
    
    System.out.println(list);
   }
 }

// [5, 4, 3, 2, 1]
