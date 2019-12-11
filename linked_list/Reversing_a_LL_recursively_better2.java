import java.util.*;

class Node<Integer>{
    int data;
    Node<Integer> next;
    Node(int data){
        this.data = data;
        next = null;
    }
}



class ReverseLL{
    
    Node<Integer> reverse(Node<Integer> head){
        if(head == null || head.next == null)      // 1 2 3 4 5 
            return head;
            
        Node<Integer> tail = head.next;           // tail is always 2 (i.e, head.next)  so no need to traverse again and again
        Node<Integer> finalHead = reverse(head.next); // 1 5 4 3 2(tail) 
        tail.next = head;
        head.next = null;      // 5 4 3 2 1 null
        return finalHead;
    }
    
}



public class Main{
    
    
    public static void printer(Node<Integer> h1){
        while(h1!=null){
            System.out.print(h1.data + " ");
            h1 = h1.next;
        }
        System.out.println();
    }
    
    
    public static void main(String args[]){
        
        Node<Integer> node1 = new Node<Integer>(1);
        Node<Integer> node2 = new Node<Integer>(2);
        Node<Integer> node3 = new Node<Integer>(3);
        Node<Integer> node4 = new Node<Integer>(4);
        Node<Integer> node5 = new Node<Integer>(5);
        Node<Integer> head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        
        printer(head);
        ReverseLL ob = new ReverseLL();
        head = ob.reverse(head);
        printer(head);
    }
    
}
