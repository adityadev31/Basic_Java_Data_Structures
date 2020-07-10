import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 3);
        map.put(2, 1);
        map.put(3, 2);
        map.put(4, 1);
        map.put(5, 3);
        
        
        // inserting in a list and sorting frequency (map value) using comparator and  ( M A P. E N T R Y )
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>(){
            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2){
                int n = e2.getValue() - e1.getValue();
                if(n == 0) return e1.getKey()-e2.getKey();   // if same freq then select lower key 
                return n;
            }
        });
        
        // getting ans
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Integer, Integer> x : list){
            int i=0;
            while(++i <= x.getValue()){
                sb.append(x.getKey() + " ");
            }
        }
        
        System.out.println(sb);
    }
}

// 1 1 1 5 5 5 3 3 2 4
