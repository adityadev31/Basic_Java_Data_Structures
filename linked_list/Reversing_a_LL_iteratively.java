/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/


class Node<T>{
    T data;
    Node<T> next;
    Node(T data){
        this.data = data;
        next = null;
    }
}


class MakeList{
    
    ///////// I N S E R T ////////
    
    Node<Integer> insert(Node<Integer> head, int x){
        Node<Integer> temp = new Node<Integer>(x);
        if(head != null)
            temp.next = head;
        head = temp;
        return head;
    }
    
    /////// P R I N T ////////
    
    void printList(Node<Integer> head){
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
    
    /////////// R E V E R S E ////////
    
    Node<Integer> reverseList(Node<Integer> head){
        Node<Integer> l = head;
        Node<Integer> m = l.next;
        Node<Integer> r = m.next;
        while(r != null){
            if(l == head)
                l.next = null;
            m.next = l;
            l = m;
            m = r;
            r = r.next;
        }
        m.next = l;     // the last swap
        return m;       // m = new head
    }
}


public class Main
{
	public static void main(String[] args) {
		MakeList ob = new MakeList();
		Node<Integer> head = null;
		head = ob.insert(head, 0);
		head = ob.insert(head, 1);
		head = ob.insert(head, 2);
		head = ob.insert(head, 3);
		head = ob.insert(head, 4);
		head = ob.insert(head, 5);
		head = ob.insert(head, 6);
		ob.printList(head);
		System.out.println();
		
		head = ob.reverseList(head);        // reversing list
		ob.printList(head);                 // printing reversed list
	}
}
