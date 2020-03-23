import java.util.*;

public class Main {
    
    public static boolean hasPath(int n[][], int sv, int ev, boolean visited[]){
        visited[sv] = true;
        for(int i=0; i<n.length; i++){
            if(n[sv][i]==1 && !visited[i]){
                if(i==ev)
                    return true;
                return hasPath(n, i, ev, visited);
            }
        }return false;
    }
    
    public static boolean hasPath(int n[][], int sv, int ev){
        boolean visited[] = new boolean[n.length];
        return hasPath(n, sv, ev, visited);
    }
    
    public static void main(String[] args) throws Exception {
        int matrix[][] = new int[5][5];
        matrix[0][1]=1;
        matrix[1][2]=1;
        matrix[2][0]=1;
        matrix[3][4]=1;
        matrix[1][0]=1;
        matrix[2][1]=1;
        matrix[0][2]=1;
        matrix[4][3]=1;
        System.out.println(hasPath(matrix, 0, 3));
    }
}


// graph - 0-1 1-2 2-0 3-4
// o/p - false
