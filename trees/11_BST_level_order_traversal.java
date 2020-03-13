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


public class Main{
    
    
    // L E V E L - O R D E R
    
    public static void levelOrder(Node root){
        Queue<Node> li = new LinkedList<>();
        li.add(root);           // add to queue (enqueue)
        while(li.size()!=0){
            Node x = li.poll();  //return the top element and dequeue
            System.out.print(x.data + " ");
            if(x.left!=null)
                li.add(x.left);
            if(x.right!=null)
                li.add(x.right);
        }
    }
    
    
    // I N O R D E R
    
    public static void inOrder(Node root){
        if(root==null)
            return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
    
    
    public static Node Bst(int data, Node root){
        if(root==null){
            Node temp = new Node(data);
            return temp;
        }
        if(data<root.data)
            root.left = Bst(data, root.left);
        else
            root.right = Bst(data, root.right);
        return root;
    }
    
    public static void main(String args[]){
        Node root = null;
        root = Bst(5, root);
        root = Bst(4, root);
        root = Bst(2, root);
        root = Bst(1, root);
        root = Bst(6, root);
        root = Bst(3, root);
        inOrder(root);
        System.out.println();
        levelOrder(root);
    }
}



/*
 *  inorder - 1 2 3 4 5 6 
 *  level   - 5 4 6 2 1 3 
 */
