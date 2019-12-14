import java.util.*;

class TreeNode<T>{
    T data;
    ArrayList<TreeNode<T>>  children;
    TreeNode(T data){
        this.data = data;
        children = new ArrayList<>();
    }
}


public class Main
{
    
    ///  P R E O R D E R   T R A V E R S E  ///
    
    public static void preOrder(TreeNode<Integer> root){
        if(root == null){return;}
        System.out.print(root.data + " ");
        for(int i=0; i<root.children.size(); i++){
            preOrder(root.children.get(i));
        }
    }
    
    
    ///  C O U N T  L E A F  N O D E S  ///
    
    public static int countLeaf(TreeNode<Integer> root){
        if(root == null) {return 0;}
        if(root.children.size() == 0){
            return 1;
        }
        int leaves = 0;
        for(int i=0; i<root.children.size(); i++){
            leaves += countLeaf(root.children.get(i));
        }return leaves;
    }
    
    
    ///  D E P T H   O F   N O D E  ///
    
    public static void depthNode(TreeNode<Integer> root, int k){
        if(k < 0) {return ;}
        if(k == 0) { System.out.print(root.data + " "); }  // b a s e  c a s E
        for(int i=0; i<root.children.size(); i++){
            depthNode(root.children.get(i), k-1);
        }
    }
    
    
    ///  M A X  N O D E  ///
    
    public static int maxNode(TreeNode<Integer> root){
        int max = root.data;                             // let root be max
        for(int i=0; i<root.children.size(); i++){
            int childData = maxNode(root.children.get(i));
            if(childData > max){
                max = childData;
            }
        }return max;
    }
    
    
    ///  H E I G H T  ///
    
    public static int treeHeight(TreeNode<Integer> root){
        if(root == null) { return Integer.MIN_VALUE; }
        int ht = 0;                                       // root node height
        for(int i=0; i<root.children.size(); i++){
            int height = 1 + treeHeight(root.children.get(i));  // total height = child height + 1
            if(height>ht){
                ht = height;
            }
        }
        return ht;
    }
    
    
    ///  C O U N T  N O D E S  ///
    
    public static int countNodes(TreeNode<Integer> root){
        if(root == null){ return Integer.MIN_VALUE; }      // for null root
        int ans = 1;                                       // for root node
        for(int i=0; i<root.children.size(); i++){
            ans += countNodes(root.children.get(i));
        }
        return ans;
    }
    
    
    ///  T A K E   I N P U T  ///
    
    public static TreeNode<Integer> takeInput(Scanner s){
        System.out.print("Enter data : ");
        int x = s.nextInt();
        System.out.print("Enter no. of children : ");
        int y = s.nextInt();
        
        TreeNode<Integer> root = new TreeNode<>(x);   // setting data
        for(int i=0; i<y; i++){
            TreeNode<Integer> child = takeInput(s);   // getting values from all the children
            root.children.add(child);
        }
        return root;
    }
    
    
    ///  P R I N T  ///
    
    public static void print(TreeNode<Integer> root){
        // for root //
        System.out.print(root.data + " : ");
        String s = "";
        for(int i=0; i<root.children.size(); i++){
            s = s + " " + root.children.get(i).data;
        }
        System.out.print(s);
        System.out.println();
        
        // for children//
        for(int i=0; i<root.children.size(); i++){ 
            print(root.children.get(i)); 
        }
    }
    
    
    /// M A I N ///
    
	public static void main(String[] args) {
	    Scanner s = new Scanner(System.in);
		TreeNode<Integer> root = takeInput(s);
		print(root);
		System.out.println("Total nodes : " + countNodes(root));
		System.out.println("Tree Height : " + treeHeight(root));
		System.out.println("Maximum Node : " + maxNode(root));
		System.out.print("Depth Node " + 2 + " : ");   depthNode(root, 2);
		System.out.println("\nLeaf Nodes : " + countLeaf(root));
		System.out.print("PreOrder : ");   preOrder(root);
		
	}
}
