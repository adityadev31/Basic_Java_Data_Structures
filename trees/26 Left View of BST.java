Example:
Input:
2
1 3 2
10 20 30 40 60 N N
Output:
1 3
10 20 40
Explanation:
Testcase 1: Below is the given tree with its nodes
         1                   
       /     \
     3        2
Here left view of the tree will be 1 3
**/





/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class Tree
{
    void leftView(Node root)
    {
      if(root == null) return;
      Queue<Node> q = new LinkedList<>();
      q.add(root);
      while(q.size() > 0){                        // using levelorder traversal
          int size = q.size();
          for(int i=0; i<size; i++){
              Node x = q.poll();
              if(i==0) System.out.print(x.data + " ");   // printing the first element of each level
              if(x.left != null) q.add(x.left);
              if(x.right != null) q.add(x.right);
          }
      }
    }
}
