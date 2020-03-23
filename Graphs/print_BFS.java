import java.util.*;

public class Main {
    
    public static void printBFS(int n[][], int sv){
        
        Queue<Integer> nodeList = new LinkedList<>();   // making a queue similar to level order trav.
        boolean visited[] = new boolean[n.length];          // to keep a record of already printed nodes
        nodeList.add(sv);                           // adding node to queue
        visited[sv] = true;                      // setting that node as visited
        
        while(nodeList.size()!=0){
            int x = nodeList.poll();                // taking first node from queue
            System.out.print(x + " ");              // printing that node
            boolean connectionFound = false;        // to check for non connected nodes
            for(int i=0; i<n.length; i++){
                if(n[x][i]==1 && visited[i]==false){     // has connection and not visited nodes
                    nodeList.add(i);                     // add and mark visited
                    visited[i] = true;                   // setting that node as visited
                    connectionFound=true;                // connection is true
                }
            }
            if(connectionFound==false){             // checking for non connected nodes
                for(int i=0; i<n.length; i++){
                    if(visited[i]==false){
                        nodeList.add(i);           // add and mark visited
                        visited[i] = true;         // setting that node as visited
                        break;
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
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
        printBFS(matrix, 0);
    }
}



/*

graph - 0-1, 0-2, 0-3, 1-4, 2-4, 3-4
output - 0 1 2 3 4

*/
