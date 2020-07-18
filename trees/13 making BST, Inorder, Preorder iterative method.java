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
    
    public static void Preorder(Node root){   // root left right   (root == print)
        Node p = root;
        Stack<Node> st = new Stack<>();
        while(1 == 1){
            while(p != null){                       
                System.out.print(p.data + " ");     // print
                st.push(p);
                p = p.left;                         // left
            }
            if(st.empty()) break;
            p = st.pop();
            p = p.right;                             // right
        }
    }
    
    public static void Inorder(Node root){      // left root right
        Stack<Node> st = new Stack<>();
        Node p = root;
        while(1==1){
            while(p != null){                   
                st.push(p);
                p = p.left;                     // left
            }
            if(st.empty()) break;
            p = st.pop();
            System.out.print(p.data + " ");     // print
            p = p.right;                        // right
        }
    }
    
    public static Node makeBST(int[] arr){
        Node root = new Node(arr[0]);
        Node p = root;
        
        for(int i=1; i<arr.length; i++){
            Node temp = new Node(arr[i]);
            p = root;
            while(1==1){
                if(temp.data <= p.data){
                    if(p.left == null){
                        p.left = temp;
                        break;
                    }
                    else p = p.left;
                }
                else{
                    if(p.right == null){
                        p.right = temp;
                        break;
                    }
                    else p = p.right;
                }
            }
        }
        return root;
    }
    
    public static void main(String[] args) throws Exception {
        int[] arr = {3,2,1,6,4,5};
        Node root = makeBST(arr);
        Inorder(root);
        System.out.println();
        Preorder(root);
    }
}
