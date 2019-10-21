
class Node<Integer>{                ////// MAKING NODES ////////
    int data;
    Node<Integer> next;
    Node(int data){
        this.data = data;
        next = null;
    }
}


class Stacks{
    
    //////// PUSH ////////
    Node<Integer> push(Node<Integer> top, int x){
        Node<Integer> temp = new Node<Integer>(x);
        if(top!=null)
            temp.next = top;
        top = temp;
        return top;
    }
    
    
    /////// POP /////////
    Node<Integer> pop(Node<Integer> top){
        top = top.next;
        return top;
    }
    
    
    
    //////// PRINT /////////
    void print(Node<Integer> top){
        while(top!=null){
            System.out.print(top.data + " ");
            top = top.next;
        }
        System.out.println();
    }
}


public class Main
{
    
	public static void main(String[] args) {
	    Node<Integer> top = null;
	    Stacks ob = new Stacks();
	    top = ob.push(top, 1);
	    top = ob.push(top, 2);
	    top = ob.push(top, 3);
	    top = ob.push(top, 4);
	    top = ob.push(top, 5);
	    top = ob.push(top, 6);
	    top = ob.push(top, 7);
	    top = ob.push(top, 8);
	    ob.print(top);
	    
	    top = ob.pop(top);
	    top = ob.pop(top);
	    ob.print(top);
	}
}
