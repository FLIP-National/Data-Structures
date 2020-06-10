import java.util.*;

class TreeSolutionFive {
  
  	public static void preOrder( Node root ) {
      
    	if( root == null)
        	return;
      
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
     
    }

 /* Node is defined as :
 class Node 
    int data;
    Node left;
    Node right;
    
    */
  	
  	
  	/* MY
  	 * CODE
  	 * STARTS
  	 * HERE
  	 */

	public static Node insert(Node root,int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node temp;
            if (data <= root.data) {
                temp = insert(root.left, data);
                root.left = temp;
            } else {
                temp = insert(root.right, data);
                root.right = temp;
            }
            return root;
        }
    }
	
	/* MY
	 * CODE
	 * ENDS
	 * HERE
	 */

	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
      	preOrder(root);
    }
}
