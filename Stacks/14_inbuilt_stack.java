
import java.util.*;

public class Main
{
	public static void main(String[] args) {
	    Stack<Integer> ob = new Stack<>();
	    ob.push(1001);
	    ob.push(1002);      // push
	    ob.push(1003);
	    System.out.println("Stack : " + ob);  // print stack
	    ob.pop();
	    ob.pop();           // pop
	    System.out.println("Stack : " + ob);
	    System.out.println("isEmpty : " + ob.isEmpty());
	}
}
