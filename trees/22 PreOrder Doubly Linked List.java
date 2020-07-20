/**



Explanation:
Testcase1: The tree is
        1
     /      \
   3       2
   
So, DLL would be 3<=>1<=>2


Testcase2: The tree is
                           10
                        /        \
                     20         30
                  /       \
               40       60
	       
So, DLL would be 40<=>20<=>60<=>10<=>30.


**/



/**

  A P P R O A C H - Doubly Linked List using proerder iterative

**/


class GfG
{
    Node preOrder(Node root){                          // preOrder iterative
        Stack<Node> st = new Stack<Node>();
        Node p = root, head = null, prev = null;
        while(1==1){
            while(p != null){
                st.push(p);
                p = p.left;
            }
            if(st.empty()) break;
            p = st.pop();
            /***************************** Extra portion in preOrder for making DLL */
            Node temp = new Node(p.data);
            if(prev == null){
                head = temp;
                prev = temp;
            }
            else{
                prev.right = temp;
                temp.left = prev;
                prev = prev.right;
            }
            /***************************/
            p = p.right;
        }
        return head;
    }
    
    Node bToDLL(Node root)
    {
	    if(root == null) return root;
	    return preOrder(root);
    }
}
