/*
M S T - connects all the nodes once with min dist
A L G O R I T H M -
DS req-
weight[] = {0, inf, inf, inf, inf, inf};
parent[] = {-1, , , , , };
visited set = []
Step1 - select the vertex with min weight[] && also not visited
Step2 - make that min vertex visited
Step3 - find all the adjacents which are (not visited && their edge weights with that vertex as source are < their current weight[] ){
            weight[edge.v] = edge.w;
            parent[edge.v] = edge.u;
        }
*/



import java.util.*;

public class Main {
    
    static class Edge{
        int u, v, w;
        Edge(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
    
    static class Graph{
        int vertices;
        boolean biDirect;
        ArrayList<ArrayList<Edge>> list;
        
        Graph(int vertices, boolean biDirect){
            this.vertices = vertices;
            this.biDirect = biDirect;
            list = new ArrayList<>();
            for(int i=0; i<vertices; i++) list.add(new ArrayList<>());
        }
        
        void addEdge(int u, int v, int w){
            if(biDirect){
                Edge edge1 = new Edge(u,v,w);
                Edge edge2 = new Edge(v,u,w);
                list.get(u).add(edge1);
                list.get(v).add(edge2);
            }
            else{
                Edge edge = new Edge(u,v,w);
                list.get(u).add(edge);
            }
        }
    }
    
    public static void prims(Graph graph, int vertices){
        
        // Initial setups of data structures used
        
        int[] parent = new int[vertices];       // DS1
        int[] weight = new int[vertices];       // DS2
        Set<Integer> visited = new HashSet<>(); // DS3
        Arrays.fill(weight, Integer.MAX_VALUE);
        weight[0] = 0;
        parent[0] = -1;
        
        // PRIMS ALGO
        
        for(int j=0; j<vertices-1; j++){        // since V-1 edges will be there in result
            
            // step1 - find the min wt[] element index
            int min = Integer.MAX_VALUE, minIdx = -1;  // lets say 0th index has min weight
            for(int i=0; i<vertices; i++){ 
                if(weight[i] < min && !visited.contains(i)){
                    min = weight[i];
                    minIdx = i;
                }
            } 
            
            // step2 - make the min visited
            visited.add(minIdx);
            
            // step3 - relax all the adjacent vertices of the min vertex
            for(Edge e : graph.list.get(minIdx)){
                if(!visited.contains(e.v) && (e.w < weight[e.v])){
                    weight[e.v] = e.w;
                    parent[e.v] = e.u;
                }
            }
        }
        int pathSum = 0;
        System.out.println("Printing Prims...");
        for(int d=1; d<vertices; d++){           // d = destination, s = source
            int s = parent[d];
            pathSum += weight[d];
            System.out.println("u: " + s + ", v: " + d + ", w: " + weight[d]);
        }
        System.out.println("\nPathSum : " + pathSum);
    }
    
    public static void main(String[] args) throws Exception {
        int vertices = 6;
        boolean biDirect = true;
        Graph graph = new Graph(vertices, biDirect);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 6);
        graph.addEdge(1, 2, 6);
        graph.addEdge(1, 3, 3);
        graph.addEdge(1, 4, 4);
        graph.addEdge(2, 3, 1);
        graph.addEdge(3, 4, 2);
        graph.addEdge(3, 5, 3);
        graph.addEdge(4, 5, 7);
        prims(graph, vertices);
    }
}


/*                  4
                1-------4
               /|\      |\
             4/ | \3    | \7
             /  |  \    |  \
            0  6|   \  2|   5
             \  |    \  |  / 
             6\ |     \ | /3
               \|      \|/
                2-------3
                    1
*/



/*
output - 
Printing Prims...
u: 0, v: 1, w: 4
u: 3, v: 2, w: 1
u: 1, v: 3, w: 3
u: 3, v: 4, w: 2
u: 3, v: 5, w: 3
PathSum : 13
*/
