import java.util.*;

class HeapSort{
    private int arr[];
    private int size;
    HeapSort(int x[]){
        arr = x;
        size = arr.length;
        add();
        remove();
        transfer();
    }
    
    // supporting functions
    private int leftChildIndex(int parentIndex){ return (2*parentIndex)+1; }
    private int rightChildIndex(int parentIndex){ return (2*parentIndex)+2; }
    private int parentIndex(int childIndex){ return (childIndex-1)/2; }
    
    // supporting functions
    private boolean hasLeftChild(int parentIndex){ return (leftChildIndex(parentIndex)<size); }
    private boolean hasRightChild(int parentIndex){ return (rightChildIndex(parentIndex)<size); }
    private boolean hasParent(int childIndex){ return (parentIndex(childIndex)>=0); }
    
    // suppoting function
    private int leftChildValue(int parentIndex){ return arr[leftChildIndex(parentIndex)]; }
    private int rightChildValue(int parentIndex){ return arr[rightChildIndex(parentIndex)]; }
    private int parentValue(int childIndex){ return arr[parentIndex(childIndex)]; }
    
    // swap function
    private void swap(int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    
    //add function              // min heap
    private void add(){
        for(int i=0; i<size; i++){
            heapifyUp(i);
        }
    }
    
    // heapifyUp
    private void heapifyUp(int childIndex){
        while(hasParent(childIndex)){
            if(arr[childIndex]<parentValue(childIndex)){
                swap(childIndex, parentIndex(childIndex));
                childIndex = parentIndex(childIndex);
            }
            else
                return;
        }
    }
    
    // remove
    Queue<Integer> myQueue = new LinkedList<>();
    private void remove(){
        int end = size-1;
        for(int i=0; i<size; i++){
            myQueue.add(arr[0]);          // adding root to queue
            arr[0] = arr[end--];          // replacing root with end and decrementing it
            heapifyDown(0, end);
        }
    }
    
    // heapifyDown
    private void heapifyDown(int parentIndex, int end){
        while(hasLeftChild(parentIndex) && leftChildIndex(parentIndex)<=end){
            int min = leftChildIndex(parentIndex);
            if(hasRightChild(parentIndex) && rightChildValue(parentIndex)<leftChildValue(parentIndex) && rightChildIndex(parentIndex)<=end)
                min = rightChildIndex(parentIndex);
            if(arr[min]<arr[parentIndex]){
                swap(min, parentIndex);
                parentIndex = min;
            }
            else
                return;
        }
    }
    
    // printer
    private void transfer(){
        int i=0;
        while(myQueue.size()!=0){
            arr[i++] = myQueue.poll();
        }
    }
}


public class Main{
    
    public static void printer(int x[]){
        for(int i=0; i<x.length; i++){
            System.out.print(x[i] + " ");
        }
    }
    
    public static void main(String args[]){
        int arr[] = {3,1,6,3,2,3,1,6,3,2,3};
        HeapSort ob = new HeapSort(arr);
        printer(arr);
    }
}
