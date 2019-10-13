class Node<T>{
	T data;
	Node<T> next;
	
	Node(T data){
		this.data = data;
		next = null;
	}
}

class Insertion<T>{
	Node<T> insertion(Node<T> head, T x){
		Node<T> temp = new Node<T>(x);
		if(head != null)
			temp.next = head;
		head = temp;
		return head;
	}
	
	void print(Node<T> head){
		while(head != null){
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
}

public class Main{

	public static void main(String args[]){
		Node<Integer> head = null;
		Insertion ob = new Insertion();
		head = ob.insertion(head, 1);
		head = ob.insertion(head, 2);
		head = ob.insertion(head, 3);
		head = ob.insertion(head, 4);
		head = ob.insertion(head, 5);
		ob.print(head);
	}	
}
