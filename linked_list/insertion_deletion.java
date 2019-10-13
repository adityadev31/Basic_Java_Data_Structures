import java.util.Scanner;         // scanner

class Node<Integer>{
	int data;
	Node<Integer> next;
	
	Node(int data){
		this.data = data;
		next = null;
	}
}

class Insert{
	Node<Integer> insert(Node<Integer> head, int x){
		Node<Integer> temp = new Node<Integer>(x);
		
		if(head!=null)
			temp.next = head;
		head = temp;
		return head;
	}
	
	Node<Integer> insert(Node<Integer> head, int x, int index){
		Node<Integer> temp = new Node<Integer>(x);
		if(index == 0){
			temp.next = head;
			head = temp;
		}
		
		else{
			int i=1;
			Node<Integer> p1 = head;
			Node<Integer> p2 = null;
			while(i<index){
				p1 = p1.next;
				i++;
			}
			p2 = p1.next;
			p1.next = temp;
			temp.next = p2;
		}
		return head;
	}
	
}



class Deletion{
	
	Node<Integer> deleted(Node<Integer> head, int index){
		if(index == 0)
			head = head.next;
			
		else{
			Node<Integer> p1 = head;
			int i=1;
			
			while(i<index){
				p1 = p1.next;
				i++;
			}
			p1.next = p1.next.next;
		}
		return head;
	}	
}



class Print{
	void print(Node<Integer> head){
		while(head!=null){
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}
}

public class Main{
	
	public static void main(String args[]){
		Insert ob = new Insert();
		Deletion del = new Deletion();
		Print pr = new Print();
		
		Node<Integer> head = null;
		head = ob.insert(head, 1);
		head = ob.insert(head, 2);
		head = ob.insert(head, 3);
		head = ob.insert(head, 4);
		head = ob.insert(head, 5);
		pr.print(head);
		
		head = ob.insert(head, 0, 2);
		head = ob.insert(head, 0, 0);
		head = ob.insert(head, 0, 4);
		head = ob.insert(head, 0, 8);
		pr.print(head);
		
		head = del.deleted(head, 0);
		pr.print(head);
		
		head = del.deleted(head, 2);
		pr.print(head);
		
		head = del.deleted(head, 5);
		pr.print(head);
	}
}
