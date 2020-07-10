import java.util.*;

public class Main{
    public static void main(String[] arts){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", 20);
        map.put("c", 10);
        map.put("b", 30);
        
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){
          public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2){
            return e1.getValue() - e2.getValue();
          }
        });
        
        System.out.println(list);
        
        System.out.println();

        // for each loop
        for(Map.Entry<String, Integer> x : list) System.out.print(x.getValue() + " ");
    }
}

/**

[c=10, a=20, b=30]

10 20 30 

**/
