/**


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
                      
                      
    CASE1 - with left != null
    CASE2 - with left == null
    
    Case1 - predecessor of root 3 = 2 (coz - 
                    - step1  move left
                    - step2  move all the way to right
                    - step3  the ending right element is the inorder predecessor
                    
                    - here 3 --> left = 1 ---> all the way to right = 2 ---> ans=2 is the inorder predecessor of 3
                    - for 8 ---> left = 5 ---> all the way to right = 7 ---> ans=7
    )

    Case2 - no left child of x ex- predecessor of 6 = 5 coz(
                    - step 1 find the latest right turn element while searching (that element = ans)
                    - here for 6 ---> 1st right turn = 3 --> 2nd right turn = 5 (last right = 5 hence ans = 5)
    )
    
    NOTE - since Case 2 require upper movement and Case 1 require lower movement from x and for searching we have to start from top
         - we will start from case 2 and keep storing right move elements
         - and after reaching x if x has left child then case 1 will start other wise case2 i.e, return store element
         - for case1 - move 1 left and all the way to right;

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
    
    /******************* PREDECESSOR ***************************/
    
    public static int predecessor(Node root, int x){
        int store = 0;
        Node p = root;
        while(p.data != x){                                     /************* CASE 1 (IF LEFT OF X = NULL) *****************/
            if(p.data < x){  // right move (so store it !!)
                store = p.data;
                p = p.right;
            }
            else p = p.left;
        }
        // now we have reached x
        if(p.left == null) return store;                         /*   (IF LEFT OF X = NULL)   */
        else{                                                    /************* CASE 2 ( IF LEFT OF X != NULL)***************/
            p = p.left;
            while(p.right != null) p = p.right;
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
        System.out.println("\n\npredecessor of 8 - " + predecessor(root, 8));
        System.out.println("predecessor of 5 - " + predecessor(root, 5));
    }
}

/**

1 2 3 4 5 6 7 8 

predecessor of 8 - 7
predecessor of 5 - 4

**/
