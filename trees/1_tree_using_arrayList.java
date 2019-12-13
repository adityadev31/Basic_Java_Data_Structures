import java.util.*;


class TreeNode<T>{
    T data;
    ArrayList<TreeNode<T>> children ;
    TreeNode(T data){                   // constructor
        this.data = data;
        children = new ArrayList<>();
    }
}


public class Main
{
    
    public static TreeNode<Integer> takeInput(Scanner s){
        System.out.print("Enter data : ");
        int x = s.nextInt();                            // taking data
        System.out.print("Enter no of children : ");
        int y = s.nextInt();                            // taking array size
        TreeNode<Integer> root = new TreeNode<>(x);         // making a node and entering above values in Integer
        
        for(int i=0; i<y; i++){                         // say y = 3 children
            TreeNode<Integer> child = takeInput(s);     // new child 
            root.children.add(child);                   // child attached to root
        }
        return root;
    }
    
    
    public static void print(TreeNode<Integer> root){
        System.out.print(root.data + " : ");
        String s = "";
        for(int i=0; i<root.children.size(); i++){
            s = s + " " + root.children.get(i).data; // printing root array data
        }
        System.out.print(s);
        System.out.println();
        for(int i=0; i<root.children.size(); i++){
            print(root.children.get(i));
        }
    }
    
    
	public static void main(String[] args) {
	    Scanner s = new Scanner(System.in);
	    TreeNode<Integer> root = takeInput(s);
		print(root);
	}
}
