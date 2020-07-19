/**
  
  
  Diameter = longest path in a tree
  
  2 possibilities:-
  
  case1 - diameter includes (root) --> height of (l+r)+1
  
  case2 - diameter does not include root (i.e, dia is in either left subtree or right subtree)
  
        - for case 2 max(leftDia, rightDia)
  
  
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
   /************ Height **************/
   public static int height(Node root){
     if(root == null) return 0;
     int l = height(root.left);
     int r = height(root.right);
     return Math.max(l, r)+1;
   }
   
   /********** Diameter ***********/
   public static int diameter(Node root){
     if(root == null) return 0;
     int l = height(root.left);
     int r = height(root.right);
     int leftDia = diameter(root.left);
     int rightDia = diameter(root.right);
     int case1 = (l+r+1);
     int case2 = Math.max(leftDia, rightDia);
     return Math.max(case1, case2);
   }
   /********************************/
   
   public static void main(String args[])
   { 
      int[] arr = {3,1,6,2,4,5};
      Node root = null;
      for(int x : arr) root = makeBST(root, x);
      System.out.println("height = "+height(root));
      System.out.println("Dia = "+diameter(root));
   }
 }

/**
  
  height = 4
  Dia = 6

  Process finished.
  
  **/
