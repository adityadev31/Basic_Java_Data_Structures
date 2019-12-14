import java.util.*;

class Tree<T>{
    T data;
    Tree<T> left;
    Tree<T> right;
    Tree(T data){
        this.data = data;
        left = null;
        right = null;
    }
}

public class Main
{
    
    public static void preorder(Tree<Integer> root){
        if(root == null)
            return ;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    
    public static void postorder(Tree<Integer> root){
        if(root == null)
            return ;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }
    
    public static void inorder(Tree<Integer> root){
        if(root == null)
            return ;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    
    
    public static Tree<Integer> takeInput(Tree<Integer> root, int x){
        if(root == null){
            Tree<Integer> child = new Tree<>(x);
            return child;
        }
        if(x<root.data)
            root.left = takeInput(root.left, x);
        else
            root.right = takeInput(root.right, x);
        return root;
    }
    
    
    public static Tree<Integer> inputDriver(){
        Tree<Integer> root = null;
        Scanner s = new Scanner(System.in);
	    int x = s.nextInt();
	    while(x!=-1){
	        root = takeInput(root, x);
	        x = s.nextInt();
	    }return root;
    }
    
    
	public static void main(String[] args) {
	    Tree<Integer> root = inputDriver();
	    System.out.print("Preorder : "); preorder(root); System.out.println();
	    System.out.print("Postorder : "); postorder(root); System.out.println();
	    System.out.print("Inorder : "); inorder(root); System.out.println();
	}
}
