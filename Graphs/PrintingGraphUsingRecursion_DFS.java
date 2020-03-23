public class Main{
    
    public static void printGraph(int n[][], int sv, boolean visited[]){
        if(visited[sv]==false){
            System.out.print(sv + " ");                 // print vertex
            visited[sv]=true;                           // add it to visited
            for(int i=0; i<n.length; i++){              // find connected non visited vertex
                if(n[sv][i]==1 && visited[i]==false){
                    printGraph(n, i, visited);
                }
            }
            for(int i=0; i<visited.length; i++){  // for non connected vertices
                if(visited[i]==false){
                    printGraph(n, i, visited);
                }
            }
        }
    }
    public static void printGraph(int n[][], int sv){
        boolean visited[] = new boolean[n.length];      // to not to repeat visited nodes
        printGraph(n, sv, visited);
    }
    
    
    public static void main(String[] args){
        // our matrix
        int size = 5;
        int matrix[][] = new int[size][size];
        matrix[0][1]=1;
        matrix[1][0]=1;
        matrix[0][2]=1;
        matrix[2][0]=1;
        matrix[0][3]=1;
        matrix[3][0]=1;
        matrix[1][4]=1;
        matrix[4][1]=1;
        matrix[2][4]=1;
        matrix[4][2]=1;
        matrix[3][4]=1;
        matrix[4][3]=1;
        // graph is ready
        
        // printing graph
        printGraph(matrix, 0);
    }
}



//  given graph is 0-1 0-2 0-3 1-4 2-4 3-4
//  output         0 1 4 2 3
