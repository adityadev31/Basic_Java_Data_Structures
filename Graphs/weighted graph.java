import java.util.*;

public class Main{
    
    static class Edge{
        int u, v, w;
        public Edge(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }    
    
    static class Graph{
        
        int vertices;
        ArrayList<ArrayList<Edge>> list;
        
        public Graph(int vertices){
            this.vertices = vertices;
            list = new ArrayList<>();
            for(int i=0; i<vertices; i++) list.add(new ArrayList<>());
        }
        
        public void addEdge(int u, int v, int w){
            Edge edge = new Edge(u, v, w);
            list.get(u).add(edge);
        }
        
        public void printGraph(){
            for(int i=0; i<list.size(); i++){
                for(Edge x: list.get(i)){
                    System.out.println("source = " + x.u + ", destination = " + x.v + " weight = " + x.w);
                }
            }
        }
        
    }
    
    public static void main(String[] args){
        int vertices = 6;
        Graph graph = new Graph(vertices);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 3, 2);
        graph.addEdge(1, 2, 5);
        graph.addEdge(2, 3, 7);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 0, 4);
        graph.addEdge(4, 1, 4);
        graph.addEdge(4, 5, 6);
        graph.printGraph();
    }
    
}
