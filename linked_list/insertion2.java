import java.util.Scanner;  // Import the Scanner class

class Node<T>{
	T data;
	Node<T> next;
	
	Node(T data){
		this.data = data;
		next = null;
	}
}

class Insertion{
	
	Node<Integer> insert(){
		Node<Integer> head = null;
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		while(x!=-1){
			Node<Integer> temp = new Node<Integer>(x);
			if(head!=null)
				temp.next = head;
			head = temp;
			x = scan.nextInt();
		}
		return head;
	}
}

public class Main{

	public static void print(Node<Integer> head){
		while(head != null){
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
	
	public static void main(String args[]){
		Insertion ob = new Insertion();
		Node<Integer> head = ob.insert();
		print(head);
	}
}
