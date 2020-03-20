import java.util.*;

class MyHeap{
    int x[];
    int size=0;
    MyHeap(int[] arr){
        x = arr;
        size = x.length;
        add_nodes();
        remove_nodes();
    }
    
    // some supporting functions
    
    // getting indexes
    private int getLeftChildIndex(int parentIndex){return (2*parentIndex)+1;}
    private int getRightChildIndex(int parentIndex){return (2*parentIndex)+2;}
    private int getParentIndex(int childIndex){return (childIndex-1)/2;}
    
    // getting existence 
    private boolean hasParent(int childIndex){return getParentIndex(childIndex)>=0;}
    private boolean hasLeftChild(int parentIndex){return getLeftChildIndex(parentIndex)<size;}
    private boolean hasRightChild(int parentIndex){return getRightChildIndex(parentIndex)<size;}
    
    // values
    private int parentValue(int childIndex){return x[getParentIndex(childIndex)];}
    private int leftChildValue(int parentIndex){return x[getLeftChildIndex(parentIndex)];}
    private int rightChildValue(int parentIndex){return x[getRightChildIndex(parentIndex)];}
    
    // swap
    private void swap(int i, int j){
        int temp = x[i];
        x[i] = x[j];
        x[j] = temp;
    }
    
    // main program (min heap)
    
    // add_nodes
    
    private void heapify_up(int i){
        while(hasParent(i)){
            if(x[i] < parentValue(i))
                swap(i, getParentIndex(i));
            else
                return;
            i = getParentIndex(i);  // updating i to check upwards
        }
    }
    
    private void add_nodes(){
        for(int i=0; i<size; i++){
            heapify_up(i);
        }
    }
    
    // remove root
    Queue<Integer> myQueue = new LinkedList<>();
    
    private void heapify_down(int start, int end){
        // if child nodes are lesser than the parent then swap
        // do this till no child left
        while(hasLeftChild(start) && getLeftChildIndex(start)<end){
            int min_index = getLeftChildIndex(start);
            if(hasRightChild(start) && getRightChildIndex(start)<end && rightChildValue(start)<leftChildValue(start))
                min_index = getRightChildIndex(start);
            if(x[start]>x[min_index]){
                swap(start, min_index);
                start = min_index;              // updating start to move downwards
            }
            else
                break;
        }
    }
    
    private void remove_nodes(){
        int start = 0;
        int end = size-1;
        while(end>=start){
            myQueue.add(x[start]);     // adding top most to queue
            x[start] = x[end];         // bring last to first
            heapify_down(start, end);  // applying heapify 
            end -= 1;                  // decrementing end
        }
    }
    
    // printer
    
    void printer(){
        while(myQueue.size()!=0){
            System.out.print(myQueue.poll() + " ");
        }
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        int arr[] = {4,3,7,5,1,9,2,6,8};
        MyHeap ob = new MyHeap(arr);
        ob.printer();
    }
}
