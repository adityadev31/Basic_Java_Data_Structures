import java.util.ArrayList;

class PriorityQ{
    ArrayList<Integer> list = new ArrayList<>();
    
    int size(){ return list.size(); }
    
    private int getLCI(int PI){ return(2*PI)+1; }
    private int getRCI(int PI){ return(2*PI)+2; }
    private int getPI(int CI){ return(CI-1)/2; }
    
    
    private boolean hasLC(int PI){ return(getLCI(PI)<size()); }
    private boolean hasRC(int PI){ return(getRCI(PI)<size()); }
    private boolean hasP(int CI){ return(getPI(CI)>=0); }
    
    
    private int LCV(int PI){ return(list.get(getLCI(PI))); }
    private int RCV(int PI){ return(list.get(getRCI(PI))); }
    private int PV(int CI){ return(list.get(getPI(CI))); }
    
    int getMin(){ return (size()>0 ? list.get(0):-1); }
    
    private void swap(int a, int b){
        int temp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, temp);
    }
    
    void add(int x){
        list.add(x);
        // heapify-up
        int CI = size()-1;
        while(hasP(CI)){
            if(PV(CI)>list.get(CI)){
                swap(getPI(CI), CI);
                CI = getPI(CI);
            }
            else
                return;
        }
    }
    
    
    int poll(){
        int temp = list.get(0);
        swap(0, size()-1);
        list.remove(size()-1);
        // heapify-down
        int PI = 0;
        while(hasLC(PI)){
            int min = getLCI(PI);
            if(hasRC(PI) && RCV(PI)<LCV(PI))
                min = getRCI(PI);
            if(list.get(PI)>list.get(min)){
                swap(PI, min);
                PI = min;
            }
            else
                return temp;
        }
        return temp;
    }
}



class Main{
    public static void main(String[] x){
        PriorityQ ob = new PriorityQ();
        ob.add(4);
        ob.add(6);
        ob.add(3);
        ob.add(5);
        ob.add(1);
        ob.add(8);
        ob.add(2);
        ob.add(7);
        while(ob.size()!=0){ System.out.print(ob.poll() + " "); }
    }
}
