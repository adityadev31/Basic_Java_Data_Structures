import java.util.*;

public class Main {
    
    static class Pair{
        int i, j;
        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    
    public static boolean dfs(int[][] maze, int m, int n){
        Stack<Pair> st = new Stack<>();
        boolean visited[][] = new boolean[m][n];
        int dir[][] = {{0,1},{0,-1},{1,0},{-1,0}};
        
        st.push(new Pair(0, 0));
        while(!st.empty()){
            Pair x = st.pop();
            if(!visited[x.i][x.j]) visited[x.i][x.j]= true;
            if(x.i == m-1 && x.j == n-1) return true;
            for(int i=0; i<4; i++){
                int a = x.i + dir[i][0];
                int b = x.j + dir[i][1];
                if(a>=0&&b>=0&&a<m&&b<n&&maze[a][b]==1&&!visited[a][b]) st.push(new Pair(a,b));
            }
        }return false;
    }
    
    public static void main(String[] args) throws Exception {
        int maze[][] = {
            {1,1,0,1},
            {0,1,0,0},
            {0,1,1,1},
        };
        
        System.out.println(dfs(maze, maze.length, maze[0].length));
    }
}


// output - true
