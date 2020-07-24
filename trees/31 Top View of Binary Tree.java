// hackerrank url - https://www.hackerrank.com/challenges/tree-top-view/problem

/**


You are given a pointer to the root of a binary tree. Print the top view of the binary tree.
Top view means when you look the tree from the top the nodes, what you will see will be called the top view of the tree. See the example below.
You only have to complete the function.
For example :

   1
    \
     2
      \
       5
      /  \
     3    6
      \
       4
Top View : 1 -> 2 -> 5 -> 6

Input Format

You are given a function,

void topView(node * root) {

}
Constraints

1 Nodes in the tree  500

Output Format

Print the values on a single line separated by space.

Sample Input

   1
    \
     2
      \
       5
      /  \
     3    6
      \
       4
Sample Output

1 2 5 6

Explanation

   1
    \
     2
      \
       5
      /  \
     3    6
      \
       4
From the top only nodes 1,2,5,6 will be visible.



**/




import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

	/* 
    
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/

    public static class Pair{
        int hd;
        Node node;
        Pair(Node x, int y){
            this.node = x;
            this.hd = y;
        }
    }

	public static void topView(Node root) {
      
      HashMap<Integer, Integer> map = new HashMap<>();
      Queue<Pair> q = new LinkedList<>();
      q.add(new Pair(root, 0));
      if(!map.containsKey(0)) map.put(0, root.data);

      while(!q.isEmpty()){
          Pair x = q.poll();
          if(x.node.left!=null){
              q.add(new Pair(x.node.left, x.hd-1));
              if(!map.containsKey(x.hd-1)) map.put(x.hd-1, x.node.left.data);
              // no need to insert if already inserted in the first place
          }
          if(x.node.right!=null){
              q.add(new Pair(x.node.right, x.hd+1));
              if(!map.containsKey(x.hd+1)) map.put(x.hd+1, x.node.right.data);
              // no need to insert if already inserted in the first place
          }
      }
      
      StringBuilder sb = new StringBuilder();
      // sort first
      ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
      Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>(){
          public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2){
              return e1.getKey()-e2.getKey();
          }
      });

      // printing
      for(Map.Entry<Integer, Integer> x : list) sb.append(x.getValue()+" ");
      System.out.println(sb);
    }

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        topView(root);
    }	
}
