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
    
    public static void DQprint(Node head){
        Node trav = head;
        while(trav != null){
            System.out.print(trav.data + " ");
            trav = trav.right;
        }
    }
    
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
    
    public static Node LevelOrder(Node root){
        Node head=null, prev = null;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node x = q.poll();
            Node current = new Node(x.data);
            if(prev == null){
                head = current;
                prev = current;
            }
            else{
                prev.right = current;
                current.left = prev;
                prev = current;
            }
            if(x.left!=null) q.add(x.left);
            if(x.right!=null) q.add(x.right);
        }
        return head;
    }
    
    
    public static void main(String[] args) throws Exception {
        int[] arr = {4,1,3,2,6,5,8,7};
        Node root = makeBSt(arr);
        Node head = LevelOrder(root);
        DQprint(head);
    }
}


// 4 1 6 3 5 8 2 7 
