
/**

  A P P R O A C H -
  
  if root == null => return true
  if (root.data > max) || (root.data < min => false)
  for left call update max and vice versa

**/



public class Tree
{
    static List<Integer> list = new ArrayList<>();
    
    boolean isBSTUtil(Node root, int min, int max) {
        if(root == null) return true;
        if(root.data < min || root.data > max) return false;
        return (isBSTUtil(root.left, min, root.data-1) && isBSTUtil(root.right, root.data+1, max));
    }
    
    boolean isBST(Node root) {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
