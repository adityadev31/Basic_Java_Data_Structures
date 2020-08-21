/*  Dijktras = single source shortest path

    A L G O R I T H M -
    
    Step1 - select the min weight[] vertex which is not yet processed
    
    Step2 - make the selected vertex as processed
    
    Step3 - relax ALL the adjacent vertices as Math.min( costofV, costofU + w )
            or Min( weight[x.v], weight[x.u]+x.w )

*/


import java.util.*;

public class Main{
    
    static class Edge{
        int u, v, w;
        Edge(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
    
    static class Graph{
        int V;
        boolean biDirect;
        ArrayList<ArrayList<Edge>> list;
        
        Graph(int V, boolean biDirect){
            this.V = V;
            this.biDirect = biDirect;
            list = new ArrayList<>();
            for(int i=0; i<V; i++) list.add(new ArrayList<>());
        }
        
        void addEdge(int u, int v, int w){
            if(biDirect){
                Edge e1 = new Edge(u, v, w);
                Edge e2 = new Edge(v, u, w);
                list.get(u).add(e1);
                list.get(v).add(e2);
            }
            else{
                Edge e = new Edge(u, v, w);
                list.get(u).add(e);
            }
        }
    }
    
    public static void dijkstra(Graph graph, int V){
        
        Set<Integer> visited = new HashSet<>();
        int[] weight = new int[V];
        Arrays.fill(weight, Integer.MAX_VALUE);
        weight[0] = 0;
        
        for(int j=0; j<V-1; j++){
            
            int min = Integer.MAX_VALUE, minIdx = -1;           // step1
            for(int i=0; i<V; i++){
                if(weight[i] < min && (!visited.contains(i))){
                    min = weight[i];
                    minIdx = i;
                }
            }
            visited.add(minIdx);                                // step2
            
            for(Edge x : graph.list.get(minIdx)){               // step3
                if(!visited.contains(x.v)){
                    weight[x.v] = Math.min(weight[x.v], weight[x.u]+x.w);
                }
            }
        }
        
        // printing..
        for(int i=0; i<V; i++) System.out.println("From 0 to "+ i + " --> " + weight[i]);
    }
    
    public static void main(String[] args){
        int V = 6;
        boolean biDirect = true;
        Graph graph = new Graph(V, biDirect);
        graph.addEdge(0,1,1);
        graph.addEdge(0,2,4);
        graph.addEdge(1,2,4);
        graph.addEdge(1,3,2);
        graph.addEdge(1,4,7);
        graph.addEdge(2,3,3);
        graph.addEdge(3,4,4);
        graph.addEdge(3,5,6);
        graph.addEdge(4,5,7);
        dijkstra(graph, V);
    }
    
}

/*                  7
                1-------4
               /|\     /|\
             1/ | \2  / | \7
             /  |  \ /  |  \
            0  4|   \  4|   5
             \  |  / \  |  / 
             4\ | /5  \ | /6
               \|/     \|/
                2-------3
                    3
*/

/*

    O U T P U T - 
    
    From 0 to 0 --> 0
    From 0 to 1 --> 1
    From 0 to 2 --> 4
    From 0 to 3 --> 3
    From 0 to 4 --> 7
    From 0 to 5 --> 9

*/
