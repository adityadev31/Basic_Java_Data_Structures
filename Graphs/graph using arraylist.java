import java.util.*;

public class Main {
    
    public static void addEdges(ArrayList<ArrayList<Integer>> edges, int u, int v){
        edges.get(u).add(v);
        edges.get(v).add(u);
    }
    
    public static void printAdjList(ArrayList<ArrayList<Integer>> edges){
        int i=0;
        for(ArrayList<Integer> x : edges){
            System.out.print(i++ +"-->");
            for(int m : x) System.out.print(m+" ");
            System.out.println();
        }
    }
    
    public static void main(String[] args) throws Exception {
        int v = 5;
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>(v);
        for(int i=0; i<v; i++) list.add(new ArrayList<Integer>());
        
        // adding edges 1 by 1
        addEdges(list, 0, 1);
        addEdges(list, 0, 4);
        addEdges(list, 1, 2);
        addEdges(list, 1, 3);
        addEdges(list, 1, 4);
        addEdges(list, 2, 3);
        addEdges(list, 3, 4);
        
        // print list
        printAdjList(list);
    }
}




/**

0-->1 4 
1-->0 2 3 4 
2-->1 3 
3-->1 2 4 
4-->0 1 3 


**/
