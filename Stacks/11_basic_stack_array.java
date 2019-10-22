class Stacks{
    
    int arr[];
    int top;
    int max;
    
    
    /// CONST ///
    Stacks(int size){
        top = -1;
        max = size;
        arr = new int[size];
    }
    
    
    
    /// IS_FULL ///
    boolean isFull(){
        if(top == max-1)
            return true;
        return false;
    }
    
    
    
    /// IS_EMPTY ///
    boolean isEmpty(){
        if(top == -1)
            return true;
        return false;
    }
    
    
    /// PUSH ///
    void push(int x){
        if(!isFull())
            arr[++top] = x;
    }
    
    
    /// POP ///
    void pop(){
        if(!isEmpty())
            top--;
    }
    
    
    /// PRINT ///
    void print(){
        if(!isEmpty()){
            for(int i=0; i<top; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
        else
            System.out.println("Empty Stack");
    }
}


public class Main
{
	public static void main(String[] args) {
	    Stacks ob = new Stacks(5);
	    ob.push(2);
	    ob.push(3);
	    ob.push(4);
	    ob.push(5);
	    ob.push(6);
	    ob.push(7);
	    ob.print();
	    
	    ob.pop();
	    ob.pop();
	    ob.print();
	    
	    
	    Stacks ob2 = new Stacks(6);
	    ob2.push(22);
	    ob2.push(33);
	    ob2.push(44);
	    ob2.push(55);
	    ob2.push(66);
	    ob2.push(77);
	    ob2.print();
	    
	    ob2.pop();
	    ob2.pop();
	    ob2.print();
	}
}
