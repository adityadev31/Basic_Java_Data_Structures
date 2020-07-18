// NOTE - DFS is same as preorder traversal


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
    
    public static Node makeBst(int[] arr){
        Node root = new Node(arr[0]);
        Node p = root;
        for(int i=1; i<arr.length; i++){
            Node temp = new Node(arr[i]);
            p = root;
            while(1==1){
                if(temp.data <= p.data){
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
        }
        return root;
    }
    
    public static void DFS(Node root){
        Node p = root;
        Stack<Node> st = new Stack<>();
        while(1==1){
            while(p != null){
                System.out.print(p.data + " ");
                st.push(p);
                p = p.left;
            }
            if(st.empty()) break;
            p = st.pop();
            p = p.right;
        }
    }
    
    public static void main(String[] args) throws Exception {
        Node root = null;
        int[] arr = {4,2,3,1,6,5,7};
        root = makeBst(arr);
        DFS(root);              // BFS is same as Level Order Traversal
    }
}

//  4 2 1 3 6 5 7 
