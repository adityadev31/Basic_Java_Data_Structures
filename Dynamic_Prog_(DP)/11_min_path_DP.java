import java.util.*;
import java.lang.Math;

public class Main {
    
    
    public static int findMinPath(int[][] maze){
        int rows = maze.length;
        int cols = maze[0].length;
        int[][] dpStore = new int[rows][cols]; // creating an array of same size as maze
        // for a cell we have to find its previous min path
        // previous will be checked by
        // i-1, j-1, i-1 && j-1
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(i==0 && j==0){                 // first value
                    dpStore[i][j] = maze[i][j];
                    continue;
                }  
                int op1=Integer.MAX_VALUE;
                int op2=Integer.MAX_VALUE;
                int op3=Integer.MAX_VALUE;
                // left
                if(i>0){op1 = dpStore[i-1][j];}
                // up
                if(j>0){op2 = dpStore[i][j-1];}
                // left-up
                if(i>0 && j>0){op3 = dpStore[i-1][j-1];}
                // find Minimum
                int minval = Math.min(op1, Math.min(op2, op3));
                // inserting min value
                dpStore[i][j] = minval + maze[i][j];
            }
        }
        return dpStore[rows-1][cols-1];
    }
    
    public static void main(String[] args) throws Exception {
        int[][] maze = {
            {1,1,1},
            {4,5,2},
            {7,8,9},
        };
        System.out.print("Minimum path = " + findMinPath(maze));
    }
}


// ans = 13
