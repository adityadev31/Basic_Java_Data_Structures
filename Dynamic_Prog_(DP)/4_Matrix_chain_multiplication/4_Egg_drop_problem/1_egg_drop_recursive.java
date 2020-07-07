import java.util.*;
import java.lang.Math;

public class Main {
    
    public static int EGG(int egg, int floor){
        if(floor == 0 || floor == 1) return floor;     // base case
        if(egg == 1) return floor;                     // base case
        int min = Integer.MAX_VALUE;
        for(int k=1; k<=floor; k++){                   // partition
            int temp = 1 + Math.max(EGG(egg-1, k-1), EGG(egg, floor-k));   // max coz worst case is asked    ( part1 = break -> egg reduce and lower floors,  part2 = not break --> egg same, upper floors)
            min = Math.min(temp, min);                                     // min coz min no. of attempts is asked
        }
        return min;
    }
    
    public static void main(String[] args) throws Exception {
        int egg = 3, floor = 15;
        System.out.println(EGG(egg, floor));
    }
}
