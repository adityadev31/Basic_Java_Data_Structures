import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int x){
        this.data = x;
        this.left = null;
        this.right = null;
    }
}

public class Main {
    
    public static Node makeBSt(int[] arr){
        Node root = new Node(arr[0]);
        Node p = root;
        for(int i=1; i<arr.length; i++){
            Node temp = new Node(arr[i]);
            p = root;
            while(1==1){
                if(temp.data<=p.data){
                    if(p.left != null) p = p.left;
                    else{
                        p.left = temp;
                        break;
                    }
                }
                else{
                    if(p.right != null) p = p.right;
                    else{
                        p.right = temp;
                        break;
                    }
                }
            }
        }return root;
    }
    
    
    public static boolean BFS(Node root, int x){  // levelorder
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node p = q.poll();
            if(p.data == x) return true;
            if(p.left != null) q.add(p.left);
            if(p.right != null) q.add(p.right);
        }
        return false;
    }
    
    
    public static boolean DFS(Node root, int x){  // preorder
        Stack<Node> st = new Stack<>();
        Node p = root;
        while(1==1){
            while(p != null){
                if(p.data == x) return true;
                st.push(p);
                p = p.left;
            }
            if(st.empty()) break;
            p = st.pop();
            p = p.right;
        }
        return false;
    }
    
    
    public static void main(String[] args) throws Exception {
        int[] arr = {4,1,3,2,6,5,8,7};
        Node root = makeBSt(arr);
        System.out.println(BFS(root, 5));
        System.out.println(DFS(root, 5));
    }
}

// 15
// 15
