import java.util.*;
import java.io.*;


/**

         1
       / | \
      6  2 3
      \ /  /\
       5  /  \
        \/    \
         4----0


**/


public class Main {
    
    public static ArrayList<ArrayList<Integer>> adjacent;
    
    // addEdges
    public static void addEdges(ArrayList<ArrayList<Integer>> edges, int u, int v){
        edges.get(u).add(v);
        edges.get(v).add(u);
    }
    
    // Print Graph
    public static void printGraph(ArrayList<ArrayList<Integer>> adjacent){
        int n = adjacent.size();
        for(int i=0; i<n; i++){
            System.out.print(i+"-->");
            for(int x : adjacent.get(i)){
                System.out.print(x+" ");
            }
            System.out.println();
        }
    }
    
    // B F S
    public static void BFS(ArrayList<ArrayList<Integer>> adjacent){
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.add(0);                                         // step1  adding first element
        while(!q.isEmpty()){                              // step2  while
            int x = q.poll();                             // step3  get poll
            if(!visited.contains(x)){                     // step4  if not visited --> make it visited and perform operation
                visited.add(x);
                System.out.print(x+" ");
            }
            for(int y : adjacent.get(x)){                 // step5  iterating adjacents and adding to the data structure if not visited
                if(!visited.contains(y)) q.add(y);
            }
        }
    }
    
    
    // D F S                                   same as BFS just use stack instead of queue
    public static void DFS(ArrayList<ArrayList<Integer>> adjacent){
       Stack<Integer> st = new Stack<>();
       Set<Integer> visited = new HashSet<>();
       st.push(0);                                     // step1  push 1st ele
       while(!st.empty()){                             // step2  while
           int x = st.pop();                           // step3  get pop
           if(!visited.contains(x)){                   // step4  if not visited --> make it visited and perform the required operation
               visited.add(x);
               System.out.print(x+" ");
           }
           for(int y : adjacent.get(x)){               // step5  iterate over adjacents and if not visited then add to stack
               if(!visited.contains(y)) st.push(y);
           }
       }
    }
    
    
    public static void main(String[] args){
        
        // initializing adjacent list
        int v = 7;
        adjacent = new ArrayList<ArrayList<Integer>>(v);
        for(int i=0; i<v; i++) adjacent.add(new ArrayList<Integer>());
        
        // adding edges
        addEdges(adjacent, 1, 6);
        addEdges(adjacent, 1, 2);
        addEdges(adjacent, 1, 3);
        addEdges(adjacent, 6, 5);
        addEdges(adjacent, 2, 5);
        addEdges(adjacent, 5, 4);
        addEdges(adjacent, 3, 4);
        addEdges(adjacent, 3, 0);
        addEdges(adjacent, 4, 0);
        
        // printing graph
        printGraph(adjacent);
        
        System.out.print("\n\nBFS\t");
        
        // B F S 
        BFS(adjacent);
        
        System.out.print("\n\nDFS\t");
        
        // D F S
        DFS(adjacent);
    }
}





/**

    0-->3 4 
    1-->6 2 3 
    2-->1 5 
    3-->1 4 0 
    4-->5 3 0 
    5-->6 2 4 
    6-->1 5 


    BFS	0 3 4 1 5 6 2 

    DFS	0 4 3 1 2 5 6 


**/
