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

public class Main {

    static class Pack {
        Node n;
        int h;
        Pack(Node n, int h) {
            this.n = n;
            this.h = h;
        }
    }
    
    // printing vertical
    public static void verticalOrder(Node root) {
        if(root == null) return new ArrayList<Integer>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<Pack> q = new LinkedList<>();
        q.add(new Pack(root, 0));
        Pack temp = null;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while(q.size()!=0) {
            temp = q.poll();
            if(temp.h < min) min = temp.h;
            if(temp.h > max) max = temp.h;
            if(!map.containsKey(temp.h))
                map.put(temp.h, new ArrayList<Integer>());
            map.get(temp.h).add(temp.n.data);
            if(temp.n.left!=null) 
                q.add(new Pack(temp.n.left, temp.h-1));
            if(temp.n.right!=null) 
                q.add(new Pack(temp.n.right, temp.h+1));
        }

        // printing from height min -> max
        for(int i=min; i<=max; i++) {
            if(map.containsKey(i)) {
                System.out.println(map.get(i));
            }
        }
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
