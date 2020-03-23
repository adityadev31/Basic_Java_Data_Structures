import java.util.*;

public class Main {
    
    public static void getPath(int n[][], int sv, int ev, boolean visited[], ArrayList<Integer> path){
        visited[sv] = true;
        path.add(sv);
        if(sv==ev){                             // if found then set all nodes as visited 
            for(int i=0; i<n.length; i++){ visited[i]=true; } //otherwise they will be sent for checking which we don't want
            return;
        }
        for(int i=0; i<n.length; i++){
            if(n[sv][i]==1 && !visited[i])
                getPath(n, i, ev, visited, path);
        }
    }
    
    public static void getPath(int n[][], int sv, int ev){
        boolean visited[] = new boolean[n.length];
        ArrayList<Integer> path = new ArrayList<>();
        getPath(n, sv, ev, visited, path);
        
        int i=0, found=-1;
        while(i!=path.size()){
            if(path.get(i)==ev){
                found=1;
                i=0;
                while(i!=path.size()){ System.out.print(path.get(i++) + " "); }
                break;
            }
            else{ i++; }
        }
        if(found!=1){ System.out.println("No path found"); }
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
        getPath(matrix, 0, 2);
    }
}
