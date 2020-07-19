/**

  N O T E - is the mirror of predecessor

    1 2 3 4 5 6 7 8
    suppose arr[] = {3,1,8,5,7,2,6,4}
    
    BST =            3
                  /    \
                 1      8
                  \    /
                   2  5
                     / \
                    4   7
                       /
                      6
                      
                      
    CASE1 - with right != null
    CASE2 - with right == null
    
    Case1 - sucsessor of root 3 = 4 (coz - 
                    - step1  move 1right
                    - step2  move all the way to left
                    - step3  the ending left element is the inorder successor
                    
                    - here 3 --> right = 8 ---> all the way to left = 4 ---> ans=4 is the inorder successor of 3
                    - for 5 ---> right = 7 ---> all the way to left = 6 ---> ans=6
    )
    Case2 - no right child of x ex- successor of 6 = 7 coz(
                    - step 1 find the latest left turn element while searching (that element = ans)
                    - here for 6 ---> 1st left turn = 8 --> 2nd left turn = 7 (last left = 7 hence ans = 7)
    )
    
    NOTE - since Case 2 require upper movement and Case 1 require lower movement from x and for searching we have to start from top
         - we will start from case 2 and keep storing right move elements
         - and after reaching x if x has right child then case 1 will start other wise case2 i.e, return store element
         - for case1 - move 1 right and all the way to left;  (i.e, smallest of right)
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

public class Main {
    
    /******************* SUCCESSOR ***************************/
    
    public static int successor(Node root, int x){
        int store = 0;
        Node p = root;
        while(p.data != x){                                     /************* CASE 1 (IF RIGHT OF X = NULL) *****************/
            if(p.data > x){  // left move (so store it !!)
                store = p.data;
                p = p.left;
            }
            else p = p.right;
        }
        // now we have reached x
        if(p.right == null) return store;                         /*   (IF RIGHT OF X = NULL)   */
        else{                                                    /************* CASE 2 ( IF RIGHT OF X != NULL)***************/
            p = p.right;
            while(p.left != null) p = p.left;
            return p.data;
        }
    }
    
    
    /******************* INORDER *******************************/
    
    public static void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    
    
    /****************** MAKING BST *****************************/
    
    public static Node makeBST(Node root, int x){
        if(root == null) return new Node(x);
        if(x<=root.data) root.left = makeBST(root.left, x);
        else root.right = makeBST(root.right, x);
        return root;
    }
    public static Node makeBST(int[] arr){
        Node root = null;
        for(int x : arr) root = makeBST(root, x);
        return root;
    }
    
    /************************************************************/
    
    public static void main(String[] args) throws Exception {
        int[] arr = {3,1,8,5,7,2,6,4};
        Node root = makeBST(arr);
        inorder(root);
        System.out.println("\n\nsuccessor of 8 - " + successor(root, 8));
        System.out.println("successor of 5 - " + successor(root, 5));
    }
}

/**

  1 2 3 4 5 6 7 8 

  successor of 8 - 0
  successor of 5 - 6

**/
