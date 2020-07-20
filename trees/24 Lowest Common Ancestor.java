/**
Explanation:
Testcase1: The BST in above test case will look like
              5
          /        \ 
        4          6
     /     \     /      \
   3      N  N       7
 /    \                 /    \ 
N   N              N     8
Here, the LCA of 7 and 8 is 7.
Testcase 2: For the given above test case the BST will be
                    2
                  /    \
                1      3
Here, the LCA of 1 and 3 will be 2


**/


/*

  A P P R O A C H - 
       - inorder approach
       - step1 - if root == null return null                    // base case
       - step2 - if root.data==n1 || root.data==n2 return root  // base case
       - step3 - left = searchLeft
       - step4 - right = searchRight
       - step5 - if left!=null and right!=null return root;
       - step6 - else return the not null one

*/



class BST
{   
    
	Node LCA(Node root, int n1, int n2)
	{
        if(root == null) return null;                           // root == null  --> null
        if(root.data == n1 || root.data == n2) return root;     // root == data  --> root
        Node left = LCA(root.left, n1, n2);                     // search left subtree
        Node right = LCA(root.right, n1, n2);                   // search right subtree
        if(left != null && right != null) return root;          // if both left and right are not null --> root
        else return (right!=null ? right : left);               // else return the not null one
    }
    
}
