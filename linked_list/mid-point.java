class Node<Integer>{
	int data;
	Node<Integer> next;
	Node(int data){
		this.data = data;
		next = null;
	}
}


class MidPoint{

	Node<Integer> midPoint(Node<Integer> head){
		Node<Integer> fast = head;
		Node<Integer> slow = head;
		while(fast.next!=null && fast.next.next!=null){
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}	
}


public class Main{
	public static void main(String args[]){
		Node<Integer> node1 = new Node<Integer>(1);
		Node<Integer> node2 = new Node<Integer>(2);
		Node<Integer> node3 = new Node<Integer>(3);
		Node<Integer> node4 = new Node<Integer>(4);
		Node<Integer> node5 = new Node<Integer>(5);
		Node<Integer> node6 = new Node<Integer>(6);
		Node<Integer> node7 = new Node<Integer>(7);
				
		Node<Integer> head = node1;
				
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		
		MidPoint mp = new MidPoint();
		System.out.println(mp.midPoint(head).data);
	}
}
