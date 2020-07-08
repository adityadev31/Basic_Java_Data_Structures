import java.util.*;
import java.lang.Math;

class HeapSort{
    private ArrayList<Integer> list = new ArrayList<>();
    private ArrayList<Integer> ans  = new ArrayList<>();
    
    private int n(){ return list.size(); }
    
    private int getPI(int CI) { return (CI-1)/2; }
    private int getLCI(int PI){ return (PI*2)+1; }
    private int getRCI(int PI){ return (PI*2)+2; }
    
    
    private boolean hasP(int CI)  {return getPI(CI)>=0;}
    private boolean hasLC(int PI) {return getLCI(PI)<n();}
    private boolean hasRC(int PI) {return getRCI(PI)<n();}
    
    
    private int PV (int CI) {return list.get(getPI(CI));}
    private int LCV(int PI) {return list.get(getLCI(PI));}
    private int RCV(int PI) {return list.get(getRCI(PI));}
    
    // swap
    private void swap(int a, int b){
        int temp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, temp);
    }
    
    
    // heapify up
    public void add(int x){
        list.add(x);
        int CI = n()-1;
        int PI;
        while(hasP(CI)){
            PI = getPI(CI);
            if(PV(CI) > list.get(CI)){
                swap(PI, CI);
                CI = PI;
            }
            else return;
        }
    }
    
    
    // heapify down
    private void hpDown(){
        ans.add(list.get(0));
        swap(0, n()-1);
        list.remove(n()-1);
        int PI = 0;
        while(hasLC(PI)){
            int min = getLCI(PI);                               // min contains LCI
            if(hasRC(PI) && RCV(PI)<LCV(PI)) min = getRCI(PI);  // min contains RCI
            if(list.get(PI) > list.get(min)){
                swap(PI, min);
                PI = min;
            }
            else return;
        }
    }
    // triggering heapify down
    private void poll(){
        while(n()!=0) hpDown();
    }
    
    public ArrayList<Integer> getSorted() { 
        poll();        // triggering heapify down
        return ans; 
    }
    
}


public class Main{
    public static void main(String args[]){
        int arr[] = {3,1,2,6,5,4};
        HeapSort ob = new HeapSort();
        ob.add(3);
        ob.add(1);
        ob.add(5);
        ob.add(2);
        ob.add(4);
        System.out.println(ob.getSorted());
    }
}

// ans = [1 2 3 4 5]
