import java.util.*;

class Graph {
    
    private class Edges {
        int u, v, w;
        Edges(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
    
    // vars
    int V;
    LinkedList<Edges>[] adj;
    
    // constructor
    Graph(int V) {
        this.V = V;
        adj = new LinkedList[this.V];
        for(int i=0; i<V; i++) 
            adj[i] = new LinkedList<>();
    }
    
    // add edge
    public void addEdge(int u, int v, int w) {
        Edges e1 = new Edges(u, v, w);
        Edges e2 = new Edges(v, u, w);
        adj[u].add(e1);
        adj[v].add(e2);
    }
    
    // PRIMS
    
    
    private class Parent implements Comparable<Parent> {
        Integer u;
        int v;
        int wt;
        Parent(Integer u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
        public int compareTo(Parent p2) {
            return this.wt - p2.wt;
        }
    }
    
    public void Prims() {
        boolean[] vis = new boolean[this.V];
        PriorityQueue<Parent> pq = new PriorityQueue<>();
        Parent par = new Parent(null, 0, 0);
        pq.add(par);
        int cost = 0;
        while(pq.size() > 0) {
            Parent x = pq.poll();           // r - remove
            if(vis[x.v]) continue;        // 
            vis[x.v] = true;              // m* - mark
            System.out.println(x.u + " -> " + x.v);   // w - work
            cost += x.wt;
            for(Edges e: adj[x.v]) {        // a* - add
                if(!vis[e.v]) {
                    pq.add(new Parent(e.u, e.v, e.w));
                }
            }
        }
        System.out.println("\ncost: " + cost);
    } 
    
}

public class Main {
    public static void main(String[] args) throws Exception {
        int V = 7;
        Graph g = new Graph(V);
        g.addEdge(0, 1, 5);
        g.addEdge(0, 3, 5);
        g.addEdge(1, 2, 1);
        g.addEdge(2, 3, 4);
        g.addEdge(1, 3, 2);
        g.Prims();
    }
}


/*

o/p

null -> 0
0 -> 1
1 -> 2
1 -> 3

cost: 8

*/
