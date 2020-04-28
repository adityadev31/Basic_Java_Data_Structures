import java.util.*;

public class Main {
    
    
    public static int findMinPath(int[][] maze, int i, int j, int rows, int cols){
        if(i==rows-1 && j==cols-1){  return maze[i][j]; }   // base case
        if(i>=rows || j>=cols){ return Integer.MAX_VALUE; } // base case
        int horiz = findMinPath(maze, i+1, j, rows, cols);
        int verti = findMinPath(maze, i, j+1, rows, cols);
        int diago = findMinPath(maze, i+1, j+1, rows, cols);
        int min = horiz;
        min = min<verti ? min:verti;
        min = min<diago ? min:diago;
        return maze[i][j]+min;
    }
    
    public static int findMinPath(int[][] maze){
        int rows = maze.length;
        int cols = maze[0].length;
        return findMinPath(maze, 0, 0, rows, cols);
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

// ans = 13 ==> 1->1->2->9
