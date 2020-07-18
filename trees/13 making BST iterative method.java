import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class Main {
    
    public static void preorder(Node root){
        if(root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    
    public static void postorder(Node root){
        if(root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }
    
    public static void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    
    // public static Node makeBST(Node root, int x){         // recursive method
    //     if(root == null) return new Node(x);
    //     if(root.data > x) root.left = makeBST(root.left, x);
    //     else root.right = makeBST(root.right, x);
    //     return root;
    // }
    
    public static Node makeBST(int[] arr){     //iterative method
        
        Node root = new Node(arr[0]);
        Node p = root;
        
        for(int i=1; i<arr.length; i++){
            Node newNode = new Node(arr[i]);
            p = root;                           // p = parent
            while(1 == 1){
                if(newNode.data <= p.data){
                    if(p.left != null) p = p.left;
                    else{
                        p.left = newNode;
                        break;
                    }
                }
                else{
                    if(p.right != null) p = p.right;
                    else{
                        p.right = newNode;
                        break;
                    }
                }
            }
        }
        return root;
    }
    
    public static void main(String[] args) throws Exception {
        int[] arr = {3,1,2,5,4,9,6,8,7};
        
        Node root = makeBST(arr);
        
        inorder(root);              // inorder
        System.out.println();
        postorder(root);            // postorder
        System.out.println();
        preorder(root);             // preorder
    }
}
