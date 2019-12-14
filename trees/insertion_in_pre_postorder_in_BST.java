class Node<Integer>{
	int data;
	Node<Integer> left;
	Node<Integer> right;
	
	Node(int data){
		this.data = data;
		left = null;
		right = null;
	}
}

class Insert_BST{
	Node<Integer> insert(Node<Integer> root, int x){      // recursive
		if(root == null){
			Node<Integer> temp = new Node<Integer>(x);               // base case
			return temp;
		}
		if(x<root.data)
			root.left = insert(root.left, x);
		
		else
			root.right = insert(root.right, x);
		
		return root;
	}
}


class Printer{
	void inorder(Node<Integer> root){           	// inorder = (left  root.data  right)
		if(root==null)
			return;				// base case
		inorder(root.left);
		System.out.print(root.data);
		inorder(root.right);
	}
	
	void preorder(Node<Integer> root){           	// preorder = (root.data  left  right)
		if(root==null)
			return;				// base case
		System.out.print(root.data);
		inorder(root.left);
		inorder(root.right);
	}
	
	void postorder(Node<Integer> root){           	// inorder = (left  right root.data)
		if(root==null)
			return;				// base case
		inorder(root.left);
		inorder(root.right);
		System.out.print(root.data);
	}
}


public class Main{
	public static void main(String args[]){
		Node<Integer> root = null;
		
		Insert_BST ins = new Insert_BST();
		Printer pr = new Printer();
		
		root = ins.insert(root, 4);
		root = ins.insert(root, 1);
		root = ins.insert(root, 7);
		root = ins.insert(root, 2);
		root = ins.insert(root, 3);
		root = ins.insert(root, 9);
		root = ins.insert(root, 10);
		root = ins.insert(root, 5);
		root = ins.insert(root, 8);
		root = ins.insert(root, 6);
		
		pr.inorder(root);
		System.out.println();
		
		pr.preorder(root);
		System.out.println();
		
		pr.postorder(root);
		System.out.println();
	}
}
