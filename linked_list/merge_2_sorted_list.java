class Node<Integer>{
	int data;
	Node<Integer> next;
	Node(int data){
		this.data = data;
		next = null;
	}
}


class Merge{

	Node<Integer> merge(Node<Integer> head1, Node<Integer> head2){
		if(head1 == null)
			return head2;
			
		if(head2 == null)
			return head1;
		
		Node<Integer> header = null;
		Node<Integer> tail = null;
		Node<Integer> t1 = head1;
		Node<Integer> t2 = head2;
		
		if(t1.data<t2.data){
			header = t1;
			tail = t1;
			t1 = t1.next;
		}
		else{
			header = t2;
			tail = t2;
			t2 = t2.next;
		}		
		
		while(t1!=null && t2!=null){
			
			if(t1.data<t2.data){
				tail.next = t1;
				tail = t1;
				t1 = t1.next;
			}
			else{
				tail.next = t2;
				tail = t2;
				t2 = t2.next;
			}			
		}
		
		if(t1==null)
			tail.next = t2;
			
		if(t2==null)
			tail.next = t1;
			
		return header;
	}

}


public class Main{
	
	public static void print(Node<Integer> head){
		while(head!=null){
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
	
	public static void main(String args[]){
		Node<Integer> node1 = new Node<Integer>(1);
		Node<Integer> node2 = new Node<Integer>(4);
		Node<Integer> node3 = new Node<Integer>(7);
		Node<Integer> node4 = new Node<Integer>(8);
		Node<Integer> node5 = new Node<Integer>(9);
		Node<Integer> node6 = new Node<Integer>(11);
		Node<Integer> head1 = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		
		
		Node<Integer> node7 = new Node<Integer>(2);
		Node<Integer> node8 = new Node<Integer>(3);
		Node<Integer> node9 = new Node<Integer>(5);
		Node<Integer> node10 = new Node<Integer>(6);
		Node<Integer> node11 = new Node<Integer>(10);
		Node<Integer> node12 = new Node<Integer>(12);
		Node<Integer> head2 = node7;
		node7.next = node8;
		node8.next = node9;
		node9.next = node10;
		node10.next = node11;
		node11.next = node12;
		
		
		Merge ob = new Merge();
		Node<Integer> header = ob.merge(head1, head2);
		print(header);
	}
}
