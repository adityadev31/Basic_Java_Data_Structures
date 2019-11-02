/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/


class Node<Integer>{
    int data;
    Node<Integer> next;
    
    Node(int data){
        this.data = data;
        next = null;
    }
}




public class Main
{
    public static Node<Integer> reverseR(Node<Integer> head){        // 1 -> 2 -> 3 -> 4
    
        if(head == null || head.next == null)          // base case
            return head;
            
            
        Node<Integer> finalHead = reverseR(head.next);                     // 1   2 <- 3 <- 4 <- finalHead
        Node<Integer> temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = head;                                  // 1 <- 2 <- 3 <- 4 <- finalHead
        head.next = null;
        return finalHead;
    }
    
    
    
    
    
    public static void printer(Node<Integer> head){
        
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
    
    

    
	public static void main(String[] args) {
	    
	    Node<Integer> node1 = new Node<Integer>(1);
	    Node<Integer> node2 = new Node<Integer>(2);
	    Node<Integer> node3 = new Node<Integer>(3);
	    Node<Integer> node4 = new Node<Integer>(4);
	    Node<Integer> head = node1;
	    node1.next = node2;
	    node2.next = node3;
	    node3.next = node4;
	    
	    head = reverseR(head);
	    printer(head);
	    
	}
}
