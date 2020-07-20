
/**

  A P P R O A C H -
  
  step1 - apply inorder and store root data in an arraylist
  step2 - check if arraylist is in sorted order or not (i.e, a[i+1] <= a[i]

**/



public class Tree
{
    static List<Integer> list = new ArrayList<>();
    
    void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        list.add(root.data);
        inorder(root.right);
    }
    
    boolean isBST(Node root)
    {
        list.clear();
        inorder(root);
        for(int i=0; i<list.size()-1; i++){
            if(list.get(i) >= list.get(i+1)) return false;
        }
        return true;
    }
}
