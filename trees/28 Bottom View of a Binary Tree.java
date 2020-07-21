 // printing bottom
 // *NOTE - bottom view is same as vertical view just we have to fetch only the last elements of the lists*
 // i.e, no need to have an arraylist in map... map<Integer, Integer> for hd, data will automatically be updated to latest one


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

class Pair{
    Node node;
    int hd;
    Pair(Node x, int y){
        this.node = x;
        this.hd = y;
    }
}

public class Main {
    
    public static void inorder(Node root){
        int hd = 0;
        Queue<Pair> q = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        q.add(new Pair(root, hd));
        map.put(hd, root.data);
        while(!q.isEmpty()){
            Pair x = q.poll();
            if(x.node.left!=null){
                q.add(new Pair(x.node.left, x.hd-1));
                map.put(x.hd-1, x.node.left.data);
            }
            if(x.node.right!=null){
                q.add(new Pair(x.node.right, x.hd+1));
                map.put(x.hd+1, x.node.right.data);
            }
        }
        
        
        // printing bottom view
        
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>(){
            @Override
            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2){
                return e1.getKey()-e2.getKey();
            }
        });
        
        for(Map.Entry<Integer, Integer> x : list) System.out.print(x.getValue() + " ");
        System.out.println();
    }
    
    public static Node makeBST(Node root, int x){
        if(root == null) return new Node(x);
        if(x <= root.data) root.left = makeBST(root.left, x);
        else root.right = makeBST(root.right, x);
        return root;
    }
    
    public static void main(String[] args) throws Exception {
        int[] arr = {1,5,4,2,3,8,6,7,9};
        Node root = null;
        for(int x : arr) root = makeBST(root, x);
        
        inorder(root);
    }
}

/**
                         1
                          \ 
                            5
                          /  \
                         4     8
                        /     /  \
                       2     6    9
                        \     \
                          3     7

**/

// ans = 2 3 6 7 9 
