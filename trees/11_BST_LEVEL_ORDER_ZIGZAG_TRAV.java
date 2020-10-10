import java.util.*;

public class Main {
    
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }
    
    // ========= LEVEL ORDER ========
    
    public static void zig_zag_level(Node root){
        Queue<Node> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        boolean reverse = false;
        q.add(root);
        Node temp = null;
        
        while(!q.isEmpty()){
            int size = q.size();                    // size of the level
            Integer[] arr = new Integer[size];      // store the element of the level
            for(int i=0; i<size; i++){
                temp = q.poll();
                if(reverse) arr[size-1-i] = temp.data;   // if reverse = true (store in reverse)
                else arr[i] = temp.data;                 // fetch => store
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }
            reverse = !reverse;                         // after completion of the level switch the reverse
            list.add(new ArrayList<>(Arrays.asList(arr)));
        }
        for(ArrayList<Integer> x : list){    // printing the result
            System.out.println(x);
        }
    }
    
    // ========= MAKE BST ============
    
    public static Node makeBST(Node root, int val){
        if(root == null) return new Node(val);
        if(root.data > val) root.left = makeBST(root.left, val);
        else root.right = makeBST(root.right, val);
        return root;
    }
    
    public static Node makeBST(int[] arr){
        Node root = null;
        for(int i: arr) root = makeBST(root, i);
        return root;
    }
    
    // ========= MAIN ================
    
    public static void main(String[] args) throws Exception {
        int[] arr = {3,2,5,6,1,4,8,7};
        Node root = makeBST(arr);
        zig_zag_level(root);
    }
}

/*
  output => 
            [3]
            [5, 2]
            [1, 4, 6]
            [8]
            [7]

*/
