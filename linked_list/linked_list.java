class Node<T>{
    <T> data;
    Node<T> next;
    
    Node(T data){
        this.data = data;
        next = null;
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
        Node<Integer> node1= new Node<Integer>(1);
        Node<Integer> node2= new Node<Integer>(2);
        Node<Integer> node3= new Node<Integer>(3);
        Node<Integer> node4= new Node<Integer>(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        Node<Integer> head = node1;
        print(head);
    }
}
