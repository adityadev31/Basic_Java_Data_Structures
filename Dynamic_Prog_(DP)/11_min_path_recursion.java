import java.util.*;

public class Main {
    
    
    public static int findMinPath(int[][] maze, int i, int j, int sum, int rows, int cols){
        if(i==rows-1 && j==cols-1){  return sum + maze[i][j]; } // base case
        if(i>=rows || j>=cols){ return sum; }
        int horiz = findMinPath(maze, i+1, j, sum, rows, cols);
        int verti = findMinPath(maze, i, j+1, sum, rows, cols);
        int diago = findMinPath(maze, i+1, j+1, sum, rows, cols);
        int min = horiz;
        min = horiz<verti ? horiz:verti;
        min = min<diago ? min:diago;
        return maze[i][j]+min;
    }
    
    public static int findMinPath(int[][] maze){
        int rows = maze.length;
        int cols = maze[0].length;
        return findMinPath(maze, 0, 0, 0, rows, cols);
    }
    
    public static void main(String[] args) throws Exception {
        int[][] maze = {
            {1,2,4,8},
            {9,5,1,6},
            {3,2,4,5},
        };
        System.out.print("Minimum path = " + findMinPath(maze));
    }
}


// ans = 8  ==>  1->2->1->5
