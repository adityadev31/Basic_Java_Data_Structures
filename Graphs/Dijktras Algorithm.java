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












/*   ================= NEW ALPHABETICAL VERTICES ============== */

import java.util.*;

class Graph{
    private class Edge{
        int u,v,w;
        Edge(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
    ArrayList<ArrayList<Edge>> list;    // adjacency list
    int V;                              // total vertices
    Graph(int V){
        this.V = V;
        list = new ArrayList<>();
        for(int i=0; i<V; i++) list.add(new ArrayList<>()); // initializing list
    }
    /* ======= add edge ======= */
    public void addEdge(int u, int v, int w){
        Edge e1 = new Edge(u, v, w);
        Edge e2 = new Edge(v, u, w);
        list.get(u).add(e1);
        list.get(v).add(e2);
    }
    /* ======= print graph ====== */
    public void printGraph(){
        System.out.println("printing graph: ");
        for(int i=0; i<V; i++){
            for(Edge e : list.get(i)){
                if(e.u < e.v) System.out.println("u: "+e.u+", v: "+e.v+", w:"+e.w);
            }
        }
    }
    /* ======= DIJKSTRAS ALGO ======= */
    public void dijktras(int start, int end){
        int[] weights = new int[V];
        int[] parent  = new int[V];
        Set<Integer> st = new HashSet<>();
        Arrays.fill(weights, Integer.MAX_VALUE);
        weights[start] = 0;
        parent[start] = -1;
        for(int j=0; j<V-1; j++){
            int min = Integer.MAX_VALUE, minidx = -1;
            for(int i=0; i<V; i++){
                if(weights[i] < min && !st.contains(i)){
                    min = weights[i];
                    minidx = i;
                }
            }
            st.add(minidx);
            for(Edge e : list.get(minidx)){
                if(!st.contains(e.v) && weights[e.v]>weights[e.u]+e.w){
                    weights[e.v] = weights[e.u]+e.w;
                    parent[e.v] = e.u;
                }
            }
        }
        
        System.out.println("\nprinting dijktras: ");
        int p = end;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb.append((char)(end+97)+"<-- ");
        sb2.append(weights[end]+"<-- ");
        while(p != start){
            sb.append((char)(parent[p]+97)+"<-- ");
            p = parent[p];
            sb2.append(weights[p]+"<-- ");
        }
        System.out.println(sb + "path");
        System.out.println(sb2 + "weights");
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int V, E, u, v, w;
        System.out.print("Enter vertices: ");
        V = scan.nextInt();
        System.out.print("Enter edges: ");
        E = scan.nextInt(); 
        Graph gp = new Graph(V);
        for(int i=0; i<E; i++){
            System.out.println("Enter e"+(i+1));
            u = (scan.next()).charAt(0)-97;
            v = (scan.next()).charAt(0)-97;
            w = scan.nextInt();
            gp.addEdge(u, v, w);
        }
        System.out.println("Enter start node: ");
        int start = (scan.next()).charAt(0)-97;
        System.out.println("Enter end node: ");
        int end = (scan.next()).charAt(0)-97;
        gp.printGraph();
        gp.dijktras(start, end);
    }
}


/*
                         5
                   a------------b
                   | \  \       \  
                   |   \   \10   \  6
                  1|   4\    -----e
                   |      \       /
                   |       \     /  5
                   c----------d
                        2
*/

/*
Enter vertices: 5                                                                             
Enter edges: 7                                                                                
Enter e1                                                                                      
a                                                                                             
b                                                                                             
5                                                                                             
Enter e2                                                                                      
a                                                                                             
e                                                                                             
10                                                                                            
Enter e3                                                                                      
a                                                                                             
d                                                                                             
4                                                                                             
Enter e4                                                                                      
a                                                                                             
c                                                                                             
1  
Enter e5                                                                                      
b                                                                                             
e                                                                                             
6                                                                                             
Enter e6                                                                                      
e                                                                                             
d                                                                                             
5                                                                                             
Enter e7                                                                                      
c                                                                                             
d                                                                                             
2                                                                                             
Enter start node:                                                                             
a                                                                                             
Enter end node:                                                                               
e                                                                                             
printing graph:                                                                               
u: 0, v: 1, w:5                                                                               
u: 0, v: 4, w:10                                                                              
u: 0, v: 3, w:4                                                                               
u: 0, v: 2, w:1                                                                               
u: 1, v: 4, w:6                                                                               
u: 2, v: 3, w:2                                                                               
u: 3, v: 4, w:5                                                                               
                                                                                              
printing dijktras:                                                                            
e<-- d<-- c<-- a<-- path                                                                      
8<-- 3<-- 1<-- 0<-- weights  
*/
