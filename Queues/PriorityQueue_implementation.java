import java.util.*;

class PriorityQException extends Exception {}

class PQElement<T> {
    T val;
    int priority;
    
    PQElement(T val, int priority) {
        this.val = val;
        this.priority = priority;
    }
}

class PriorityQ<T> {
    ArrayList<PQElement<T>> heap;
    PriorityQ() {
        heap = new ArrayList<>();
    }
    
    // insert
    void insert(T val, int pr) {
        PQElement<T> ele = new PQElement<>(val, pr);
        heap.add(ele);
        // up heapify
        int child = heap.size()-1;
        int parent = (child-1)/2;
        while(parent >= 0) {
            if(heap.get(child).priority < heap.get(parent).priority) {
                PQElement<T> temp = heap.get(child);
                heap.set(child, heap.get(parent));
                heap.set(parent, temp);
                child = parent;
                parent = (child-1)/2;
            }
            else return;
        }
    }
    
    // remove
    T remove() throws PriorityQException {
        try {
            if(heap.size() == 0) {
                throw new PriorityQException();
            }
            else {
                PQElement<T> temp = heap.get(0);
                // swap
                heap.set(0, heap.get(heap.size()-1));
                heap.remove(heap.size()-1);
                
                // down heapify
                int parent = 0;
                int Lchild = (2*parent+1);
                int Rchild = (2*parent+2);
                while(Lchild < heap.size()) {
                    int min = parent;
                    if(heap.get(Lchild).priority <= heap.get(min).priority) {
                        min = Lchild;
                    }
                    if(Rchild < heap.size() && heap.get(Rchild).priority <= heap.get(min).priority) {
                        min = Rchild;
                    }
                    if(min == parent) break;
                    else {
                        PQElement<T> x = heap.get(parent);
                        heap.set(parent, heap.get(min));
                        heap.set(min, x);
                        parent = min;
                        Lchild = (2*parent+1);
                        Rchild = (2*parent+2);
                    }
                }
                
                return temp.val;
            }
        } catch(PriorityQException exe) {
            System.out.println("Queue is already empty");
            return null;
        }
    }
    
    // get min
    T peek() {
        return heap.get(0).val;
    }
    
    // size
    int size() {
        return heap.size();
    }
    
    // isEmpty
    boolean isEmpty() {
        return heap.size() == 0;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        PriorityQ<Integer> q = new PriorityQ<>();
        q.insert(5,5);
        q.insert(2,2);
        q.insert(4,4);
        q.insert(1,1);
        q.insert(3,3);
        q.insert(6,6);
        
        while(!q.isEmpty()) {
            System.out.print(q.remove() + " ");
        }
    }
}
