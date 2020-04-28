import java.util.*;

public class Main {
    
    
    public static int findMinPath(int[][] maze, int i, int j, int rows, int cols, int[][] store){
        if(i==rows-1 && j==cols-1){                         // base case
            store[i][j] = maze[i][j]; 
            return store[i][j];
        }
        if(i>=rows || j>=cols){ return Integer.MAX_VALUE; } // base case
        if(store[i][j] != -1){ return store[i][j]; }        // base case (already present)
        
        // storing the min values
        int horiz = findMinPath(maze, i+1, j, rows, cols, store);
        int verti = findMinPath(maze, i, j+1, rows, cols, store);
        int diago = findMinPath(maze, i+1, j+1, rows, cols, store);
        int min = horiz;
        min = min<verti ? min:verti;
        min = min<diago ? min:diago;
        store[i][j] = maze[i][j]+min;
        return store[i][j];
    }
    
    public static int findMinPath(int[][] maze){
        int rows = maze.length;
        int cols = maze[0].length;
        int[][] store = new int[rows][cols];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                store[i][j] = -1;
            }
        }
        return findMinPath(maze, 0, 0, rows, cols, store);
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
