/**

  printing tree in vertical order :-

  A P P R O A C H -  level order approach
  
  step1 - make a map and a pair. Pair of <Node & hd> for inserting in queue  and HashMap<Integer, List<Integer>> for tracking list of nodes for a particular position
  step2 - (i) add pair to queue <Node, hd>    if(node = root.left --> hd(ofRoot)-1)
          (ii) add pair to queue <Node hd>    if(node = root.right --> hd(ofRoot)+1)
  step3 - print map
  
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

class Pair{
    Node node;
    int hd;
    Pair(Node x, int y){
        this.node = x;
        this.hd = y;
    }
}



public class Main {
    
    /**************** USING MAPS FOR STORING HD ******************/
    public static HashMap<Integer, ArrayList<Integer>> map;
    
    public static void printMap(HashMap<Integer, ArrayList<Integer>> mp){
        for(Map.Entry<Integer, ArrayList<Integer>> x : mp.entrySet()){
            System.out.println(x.getValue());
        }
    }
    
    public static void insertInMap(HashMap<Integer, ArrayList<Integer>> mp, int key, int value){
        if(!mp.containsKey(key)) mp.put(key, new ArrayList<>());
        mp.get(key).add(value);
    }
    
    
    /************** LEVEL ORDER FOR VERTICAL ********************/
    public static void levelOrder(Node root){
        int hd = 0;
        map = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, hd));          // step1 add in que 
        insertInMap(map, hd, root.data);    // step2 update map
        
        while(!q.isEmpty()){
            Pair x = q.poll();
            if(x.node.left!=null){
                q.add(new Pair(x.node.left, x.hd-1));        // step1 add in que 
                insertInMap(map, x.hd-1, x.node.left.data);  // step2 update map
            }
            if(x.node.right!=null){
                q.add(new Pair(x.node.right, x.hd+1));       // step1 add in que
                insertInMap(map, x.hd+1, x.node.right.data); // step2 update map
            }
        }
        
        printMap(map);
    }
    
    
    /************** MAKE B S T ***************/
    public static Node makeBST(Node root, int x){
        if(root==null) return new Node(x);
        if(x <= root.data) root.left = makeBST(root.left, x);
        else root.right = makeBST(root.right, x);
        return root;
    }
    
    public static void main(String[] args) throws Exception {
        int[] arr = {3,1,5,2,6,7,4,8};
        Node root = null;
        for(int x : arr) root = makeBST(root, x);   // making BST
        levelOrder(root);                           // print vertical
    }
}



/**

              3
            /   \
           1     5
            \   / \
             2  4  6
                    \
                     7
                      \
                       8
                       
    O/p- 
    
    [3, 2, 4]
    [1]
    [5]
    [6]
    [7]
    [8]





**/
