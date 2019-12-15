import java.util.*;

public class Main{
    public static void main(String[] args){
        
        /// D E C L A R I N G    M A P ///
        HashMap<String, Integer> map = new HashMap<>();
        
        
        /// I N S E R T ///        O (1)
        map.put("abc", 1);
        map.put("abc", 2);
        map.put("abc", 3);
        map.put("abc", 4);
        map.put("def", 1);
        map.put("def", 2);
        map.put("def", 3);
        map.put("def", 4);
        
        
        /// P R I N T ///
        if(map.containsKey("abc"))    // contains to check its presence
            System.out.println("has abc : " + map.get("abc")); // get for value
            
        if(map.containsKey("def"))
            System.out.println("has def : " + map.get("def")); 
            
            
        /// R E M O V E ///
        map.remove("abc");
        System.out.println(map.get("abc"));
        
        
        /// getting keys by V A L U E S ///    O(n)
        System.out.println(map.containsValue(4));    // returns boolean
    }
}
