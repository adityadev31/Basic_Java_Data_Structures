class Node<T>{
    T data;
    Node<T> next;
    Node(T data){
        this.data = data;
        next = null;
    }
}


class DoubleNode{   // class to return both head and tail by returning object
    Node<Integer> head;
    Node<Integer> tail;
}


class ReverseNodes{
    
    DoubleNode reverse(Node<Integer> head){  // return type Double (i.e both head and tail)
        
        if(head == null || head.next == null){    // B A S E  C A S E  // 
            DoubleNode ans = new DoubleNode();
            ans.head = head;
            ans.tail = head;
            return ans;
        }
        
        DoubleNode temp = new DoubleNode();  // 1 -> 2 -> 3 -> 4 -> 5
        temp = reverse(head.next);           // 1 -> (2{temp.tail} <- 3 <- 4 <- 5{temp.head})  
        temp.tail.next = head;          
        head.next = null;                    // 1 <- 2 <- 3 <- 4 <- 5
        DoubleNode ans = new DoubleNode();
        ans.tail = head;            
        ans.head = temp.head;                // 1[ans.tail] <- 2 <- 3 <- 4 <- 5[ans.head]
        return ans;                          // returns both (ans.head) and (ans.tail)
    }
    
}




public class Main{
    
    
    ///   P R I N T E R   ///
    
    public static void printList(Node<Integer> head){
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
    
    
    ///   M A I N   ///
    
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
        
        
        DoubleNode ans = new DoubleNode();
        ReverseNodes ob = new ReverseNodes();
        ans = ob.reverse(head);
        printList(ans.head);
        
    }
    
    
}
