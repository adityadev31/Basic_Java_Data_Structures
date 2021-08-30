import java.util.*;

class Graph {
    // vars
    int V;
    LinkedList<Integer>[] adj;
    
    // constructor
    Graph(int V) {
        this.V = V;
        adj = new LinkedList[this.V];
        for(int i=0; i<V; i++) 
            adj[i] = new LinkedList<>();
    }
    
    // add edge
    public void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }
    
    // BFS
    public void BFS(int src) {
        System.out.print("\nBFS: ");
        boolean[] vis = new boolean[this.V];
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while(q.size() > 0) {
            int x = q.poll();           // r - remove
            if(vis[x]) continue;        // 
            vis[x] = true;              // m* - mark
            System.out.print(x+ " ");   // w - work
            for(int v: adj[x]) {        // a* - add
                if(!vis[v]) {
                    q.add(v);
                }
            }
        }
    } 
    
    
    // DFS
    public void DFS(int src) {
        System.out.print("\nDFS: ");
        boolean[] vis = new boolean[this.V];
        Stack<Integer> st = new Stack<>();
        st.push(src);
        while(st.size() > 0) {
            int x = st.pop();               // r  -  remove
            if(vis[x]) continue;
            vis[x] = true;                  // m* -  mark
            System.out.print(x+ " ");       // w  -  work
            for(int v: adj[x]) {            // a* -  add
                if(!vis[v]) {
                    st.push(v);
                }
            }
        }
    } 
}

public class Main {
    public static void main(String[] args) throws Exception {
        int V = 7;
        Graph g = new Graph(V);
        g.addEdge(1, 6);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(6, 5);
        g.addEdge(2, 5);
        g.addEdge(3, 4);
        g.addEdge(3, 0);
        g.addEdge(4, 0);
        g.BFS(1);
        g.DFS(1);
    }
}


/*

o/p:

BFS: 1 6 2 3 5 4 0 
DFS: 1 3 0 4 2 5 6 

*/
