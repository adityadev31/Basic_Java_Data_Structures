import java.util.*;

public class Main {
    
    // Edge packet maker class
    static class Edge{
        int u, v, w;
        Edge(int u, int v, int w){  // constructor
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
    
    // Graph maker class
    static class Graph{
        
        int vertices;
        ArrayList<ArrayList<Edge>> list;
        
        Graph(int vertices){                // constructor
            this.vertices = vertices;
            list = new ArrayList<>();
            for(int i=0; i<vertices; i++) list.add(new ArrayList<>());
        }
        
        void addEdge(int u, int v, int w){      // add edges
            Edge edge = new Edge(u, v, w);
            list.get(u).add(edge);
        }
        
        void printGraph(){                  // print graph
            System.out.println("Printing Graph...");
            for(int i=0; i<list.size(); i++){
                for(Edge x : list.get(i)) System.out.println("u: " + x.u + ", v: " + x.v + ", w: " + x.w);
            }
        }
    }
    
    // priority q comparator
    static class WeightComparator implements Comparator<Edge>{
        public int compare(Edge e1, Edge e2){
            return e1.w-e2.w;
        }
    }
    
    // krushkal algo
    public static void krushkal(Graph graph, int vertices){
        
        int pathSum = 0;                            // to store sum of weights of path
        int[] parent = new int[vertices];
        for(int i=0; i<vertices; i++) parent[i] = i;  // initially nodes are parent of themselves
        
        PriorityQueue<Edge> pq = new PriorityQueue<>(new WeightComparator());  // for sorting according to weights of the edges
        
        for(int i=0; i<vertices; i++){
            for(Edge x : graph.list.get(i)) pq.add(x);  // adding edges to the pq
        }
        
        System.out.println("\nPrinting Krushkal...");
        while(!pq.isEmpty()){
            Edge x = pq.poll();
            int p1, p2;
            int i = x.u;
            while(parent[i]!=i && i<vertices && i>=0) i = parent[i];
            p1 = i;
            i = x.v;
            while(parent[i]!=i && i<vertices && i>=0) i = parent[i];
            p2 = i;
            if(p1 != p2){
                pathSum += x.w;
                parent[x.v] = p1;      // making parent of node1 as parent of node2 as they are now connected
                
                // print krushkal
                System.out.println("u: " + x.u + ", v: " + x.v + ", w: " + x.w);
                
            }
        }
        
        System.out.println("\nKrushkal Path sum = " + pathSum);     // print ans
    }
    
    
    public static void main(String[] args) throws Exception {
        int vertices = 5;
        
        /* Let us create following weighted graph 
                 1 
            0--------4 
            |      / | \
           3|   4/   |6  \7 
            |  /     |     \
            1--------2------3 
                5        2
        */
        
        // making graph
        Graph graph = new Graph(vertices);
        
        graph.addEdge(0,1,3);
        graph.addEdge(0,4,1);
        graph.addEdge(1,4,4);
        graph.addEdge(1,2,5);
        graph.addEdge(2,4,6);
        graph.addEdge(2,3,2);
        graph.addEdge(3,4,7);
        
        graph.printGraph();
        
        // krushkal
        krushkal(graph, vertices);
    }
}



/**

O U T P U T - 

Printing Graph...
u: 0, v: 1, w: 3
u: 0, v: 4, w: 1
u: 1, v: 4, w: 4
u: 1, v: 2, w: 5
u: 2, v: 4, w: 6
u: 2, v: 3, w: 2
u: 3, v: 4, w: 7

Printing Krushkal...
u: 0, v: 4, w: 1
u: 2, v: 3, w: 2
u: 0, v: 1, w: 3
u: 1, v: 2, w: 5

Krushkal Path sum = 11

**/
