class Node<Integer>{               // making of a node
	int data;
	Node<Integer> next;
	Node(int data){
		this.data = data;
		next = null;
	}
}



class LinkedList{
	
	Node<Integer> midPoint(Node<Integer> head){           // finding mid point
		
		Node<Integer> fast = head;
		Node<Integer> slow = head;
		
		while(fast.next!=null && fast.next.next!=null){
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	
	
	Node<Integer> merge(Node<Integer> head1, Node<Integer> head2){          // merging 2 lists
		
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
			
		else
			tail.next = t1;
		
		return header;
	}
	
	
	Node<Integer> divide(Node<Integer> head){         // main merge-sort function
		
		if(head==null || head.next == null)
			return head;
			
		Node<Integer> mid = midPoint(head);
		Node<Integer> midNext = mid.next;
		mid.next = null;                               // dividing into two lists
		
		Node<Integer> left = divide(head);
		Node<Integer> right = divide(midNext);
		Node<Integer> sortedList = merge(left, right);    // merging two lists
		
		return sortedList;
		
	}
		
}


public class Main{
	
	public static void print(Node<Integer> head){
		while(head!=null){
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static void main(String args[]){
		Node<Integer> node1 = new Node<Integer>(5);
		Node<Integer> node2 = new Node<Integer>(2);
		Node<Integer> node3 = new Node<Integer>(1);
		Node<Integer> node4 = new Node<Integer>(8);
		Node<Integer> node5 = new Node<Integer>(3);
		Node<Integer> node6 = new Node<Integer>(9);
		Node<Integer> node7 = new Node<Integer>(4);
		Node<Integer> node8 = new Node<Integer>(6);
		Node<Integer> node9 = new Node<Integer>(10);
		Node<Integer> node10 = new Node<Integer>(7);
				
		Node<Integer> head = node1;
		
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		node8.next = node9;
		node9.next = node10;
		
		print(head);
		
		LinkedList li = new LinkedList();
		
		head = li.divide(head);
		print(head);
	}
	
}
