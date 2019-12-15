import java.util.*;

public class Main{
    
    public static ArrayList<Integer> removeDuplicates(int arr[]){
        
        ArrayList<Integer> output = new ArrayList<>();     // to store elements after removing duplicates
        HashMap<Integer, Boolean> seen = new HashMap<>();  // to store map whether the element is already seen or not
        
        
        for(int i=0; i<arr.length; i++){
            if(seen.containsKey(arr[i]))    // if already present do nothing
                continue;
            output.add(arr[i]);             // add to the array list
            seen.put(arr[i], true);         // mark it as seen in the map
        }
        
        return output;                      // return ArrayList
    }
    
    
    public static void main(String args[]){
        int arr[] = {1,2,3,2,1,4,5,4,3,5,7,6,1};
        ArrayList<Integer> output = removeDuplicates(arr);
        for(int i=0; i<output.size(); i++){
            System.out.print(output.get(i) + " ");
        }
    }
    
}
