import java.util.*;


class Tree<T>{
    T data;
    Tree<Integer> left;
    Tree<Integer> right;
    Tree(T data){
        this.data = data;
        left = null;
        right = null;
    }
}


public class Main
{
    
    /// PRINTING INORDER  ///
    
    public static void printInorder(Tree<Integer> root){
        if(root == null)
            return;
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }
    
    
    /// INORDER AND PREORDER TO TREE /// 
    
    public static Tree<Integer> buildTree(int in[], int pre[], int inS, int inE, int preS, int preE){
        if(inS > inE){
            return null;
        }
        
        
        // STEP 1 :- finding root data by preorder
        int rootData = pre[preS];       
        Tree<Integer> root = new Tree<>(rootData); // setting root
        
        
        // STEP 2 :- for left and right find rootIndex in inorder
        int rootIndex = -1;
        for(int i=0; i<in.length; i++){
            if(in[i] == rootData){
                rootIndex = i;
                break;
            }
        }
        if(rootIndex == -1){ return null; }
        
        
        // STEP 3 :- setting parameters for left and right
        int inLS   = inS;             // inorder Left Start
        int inLE   = rootIndex - 1;   // inorder Left End
        int preLS  = preS + 1;
        int preLE  = inLE - inLS + preLS; // preLE - preLS = inLE - inLS
        int inRS   = rootIndex + 1;
        int inRE   = inE;
        int preRS  = preLE + 1;
        int preRE  = preE;
        
        
        // STEP 4 :- recursive call on left and right
        root.left  = buildTree(in, pre, inLS, inLE, preLS, preLE);
        root.right = buildTree(in, pre, inRS, inRE, preRS, preRE);
        return root;
    }
    
    
	public static void main(String[] args) {
	    int in[] = {1,3,4,5,6,8,9};
	    int pre[] = {5,3,1,4,8,6,9};
	    Tree<Integer> root = buildTree(in, pre, 0, in.length-1, 0, pre.length-1);
	    System.out.print("Inorder : ");
	    printInorder(root);
	}
}
