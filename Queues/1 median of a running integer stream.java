import java.util.*;

public class Main {
    
    static class Desc implements Comparator<Integer>{
        public int compare(Integer e1, Integer e2){ return e2-e1; }
    }
    
    public static void findMedian(int[] arr){
        int N = arr.length;
        PriorityQueue<Integer> q1 = new PriorityQueue<>(new Desc());      // max
        PriorityQueue<Integer> q2 = new PriorityQueue<>();                // min
        double mid = arr[0];
        q1.add(arr[0]);
        System.out.println(mid);
        
        for(int i=1; i<N; i++){
            int n = arr[i];
            if(q1.size() > q2.size()){
                if(n < mid){
                    q2.add(q1.poll());
                    q1.add(n);
                }
                else q2.add(n);
                mid = (double) (q1.peek() + q2.peek())/2;
            }
            else if(q1.size() == q2.size()){
                if(n < mid){
                    q1.add(n);
                    mid = q1.peek();
                }
                else{
                    q2.add(n);
                    mid = q2.peek();
                }
            }
            else{
                if(n < mid) q1.add(n);
                else{
                    q1.add(q2.poll());
                    q2.add(n);
                }
                mid = (double) (q1.peek() + q2.peek())/2;
            }
            System.out.println(mid);
        }
    }
    
    public static void main(String[] args) throws Exception {
        int arr[] = {3,1,4,2,5};
        findMedian(arr);
    }
}


/*

output:-

3.0
2.0
3.0
2.5
3.0
*/
