/**. Sum from root to a node
  
  using pre order traversal
  
  step1 - sum+=root.data , push root to stack
  
  step2 - if sum == target print stack
  
  step3 - go left , go right
  
  step4 - we are in this step means we are at the end 
          and target still not found, so undo step2
          { sum-=root.data, if(!stack empty) pop() }
  
  
  **/



import java.util.*;

 class Node{
   int data;
   Node left;
   Node right;
   Node(int x){
     this.data = x;
     this.left = null;
     this.right = null;
   }
 }

 public class Main
 {
   public static Node makeBST(Node root, int x){
     if(root == null) return new Node(x);
     if(x <= root.data) root.left = makeBST(root.left, x);
     else root.right = makeBST(root.right, x);
     return root;
   }
   
   static int sum = 0;
   static Stack<Node> st = new Stack<>();
   
   public static void printStack(){
     while(!st.empty()) System.out.print(st.pop().data+" ");
   }
   
   public static void findPathSum(Node root, int target){
     if(root == null) return;     // base case
     
     sum += root.data;                 // add sum
     st.push(root);                    // push node to stack
     if(sum == target) printStack(); // if sum == target print stack
     
     findPathSum(root.left, target);
     findPathSum(root.right, target);
     
    if(!st.empty()) st.pop();              // reversing above steps 
     sum -= root.data;             // reversing above steps as we have reached end
     
   }
   
   public static void main(String args[]){ 
      int[] arr = {3,1,6,2,4,5};
      Node root = null;
      for(int x : arr) root = makeBST(root, x);
      findPathSum(root, 13);
   }
 }

/**
  
  4 6 3

  Process finished.
  
  **/
