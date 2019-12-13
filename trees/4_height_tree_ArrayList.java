import java.util.*;

class Treenode<T>{
    T data;
    ArrayList<Treenode<T>> children;
    Treenode(T data){
        this.data = data;
        children = new ArrayList<>();
    }
}




public class Main
{
    
    ///  H E I G H T  ///
    
    public static int height(Treenode<Integer> root){
        int ht = 0;
        for(int i=0; i<root.children.size(); i++){
            int maxHeight = 1 + height(root.children.get(i));
            if(maxHeight > ht)
                ht = maxHeight;
        }
        return ht;
    }
    
    
    ///  L A R G E S T   T R E E N O D E (data)   ///
    
    public static int largest(Treenode<Integer> root){
        int ans = root.data;
        for(int i=0; i<root.children.size(); i++){
            int maxNode = largest(root.children.get(i));
            if(maxNode > ans)
                ans = maxNode;
        }
        return ans;
    }
    
    
    ///  C O U N T    N O D E  ///
    
    public static int countNodes(Treenode<Integer> root){
        int count = 1;
        for(int i=0; i<root.children.size(); i++){
            count += countNodes(root.children.get(i));
        }
        return count;
    }
    
    
    ///  I N P U T  ///
    
    public static Treenode<Integer> takeInput(Scanner s){
        System.out.print("Enter data : ");
        int x = s.nextInt();                        // getting data value
        System.out.print("Enter children : ");
        int y = s.nextInt();                        // getting no. of children 
        Treenode<Integer> root = new Treenode<>(x); // taking root data
        for(int i=0; i<y; i++){                     // taking root children
            Treenode<Integer> child = takeInput(s); // making child
            root.children.add(child);               // adding child
        }
        return root;
    }
    
    
    ///  P R I N T  ///
    
    public static void print(Treenode<Integer> root){
        System.out.print(root.data + " : ");
        int y = root.children.size();
        String st = "";
        for(int i=0; i<y; i++){
            st = st + " " + root.children.get(i).data;
        }
        System.out.print(st);
        System.out.println();
        for(int i=0; i<y; i++){
            print(root.children.get(i));
        }
    }
    
    
    /// M A I N ///
    
	public static void main(String[] args) {
	    Scanner s = new Scanner(System.in);
	    Treenode<Integer> root = takeInput(s);
		print(root);
		System.out.println("No. of nodes : " + countNodes(root));//count number of nodes
		System.out.println("MaxNode : " + largest(root));//maxNode Data
		System.out.println("Height : " + height(root));//tree height
	}
}
