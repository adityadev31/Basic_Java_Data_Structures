/**

    B F S  is same as  level order traversal

**/


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
    
    public static void BFS(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                Node x = q.poll();
                System.out.print(x.data + " ");
                if(x.left!=null) q.add(x.left);
                if(x.right!=null) q.add(x.right);
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        Node root = null;
        int[] arr = {4,2,3,1,6,5,7};
        root = makeBst(arr);
        BFS(root);              // BFS is same as Level Order Traversal
    }
}


// 4 2 6 1 3 5 7 
