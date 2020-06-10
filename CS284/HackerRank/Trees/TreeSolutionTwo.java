import java.util.*;


class TreeSolutionTwo {

/* you only have to complete the function given below.  
Node is defined as  

class Node {
    int data;
    Node left;
    Node right;
}

*/

	/* MY
	 * CODE
	 * STARTS
	 * HERE
	 */
	
    public static void postOrder(Node root) {
      if (root == null){
        return;
    } else {
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
       }
    }
    /* MY
     * CODE
     * ENDS
     * HERE
     */

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        postOrder(root);
    }
}
