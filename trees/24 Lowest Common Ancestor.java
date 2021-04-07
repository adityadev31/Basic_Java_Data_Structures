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
    // Returns the LCA of the nodes with values n1 and n2
    // in the BST rooted at 'root' 
	Node LCA(Node root, int n1, int n2)
	{
        if(root == null) return root;
        if(root.data<n1 && root.data<n2) return LCA(root.right, n1, n2);
        else if(root.data>n1 && root.data>n2) return LCA(root.left, n1, n2);
        return root;
    }
    
}
