/*Jessica Noel
 * CS284-C  Data Structures
 * Assignment 4
 * IsoTriangle
 */


public class IsoTriangle {

	public int total_iso_triangle=0;

//Node class from Quiz 5
protected class Node {

	int value;

	Node l_child;
	Node r_child;

	Integer depth;

	private Node(int value, Node l_child, Node r_child, int depth) {
		this.value = value;
		this.l_child = l_child;
		this.r_child = r_child;
		this.depth = depth;
	}

	public Node(int i) {
	// TODO Auto-generated constructor stub
	}
}

	//Test. Should return 1
	public Node build_tree_int() {
		Node four=new Node(4,null,null,4);

		Node three=new Node(3,null,null,3);

		Node seven=new Node(1,three,four,2);

		Node zero=new Node(0,seven,null,1);

		return zero;

	}

	/*Test.Should return 2 Triangles
	 *  Tests if algorithm accounts for triangles using
	 *  "shared vertices" on the right side of the tree
	 */
	public Node build_tree_int6() {
		Node six=new Node(4,null,null,4);
		Node five=new Node(4,null,null,4);

		Node three=new Node(3,five,six,3);
		Node four=new Node(3,null,null,3);

		Node two=new Node(2,three,four,2);
		Node one=new Node(2,null,null,2);

		Node zero=new Node(1,one,two,1);

		return zero;
	}

	//Test. Should return 4 Triangles
	public Node build_tree_int7() {
		Node nine=new Node(4,null,null,4);
		Node ten=new Node(4,null,null,4);
		Node six=new Node(4,null,null,4);
		Node five=new Node(4,null,null,4);

		Node seven=new Node(3,nine,ten,3);
		Node eight=new Node(3,null,null,3);
		Node three=new Node(3,five,six,3);
		Node four=new Node(3,null,null,3);

		Node two=new Node(2,three,four,2);
		Node one=new Node(2,seven,eight,2);

		Node zero=new Node(1,one,two,1);

		return zero;
	}



	/*Test. Should return 3 triangles
	 * Tests if algorithm accounts for triangles using
	 *  "shared vertices" on the left side of the tree
	 */
	public Node build_tree_int2() {
		Node five =new Node(3, null,null,3);
	    Node six =new Node(3,null,null,3);

		Node eight =new Node(4, null,null,4);
		Node nine = new Node(4, null,null, 4);

		Node four = new Node(3, null,null, 3);
        Node three =new Node(3, eight, nine,3);

		Node seven =new Node(2, three, four, 2);
        Node two =new Node(2,five,six,2);

	    Node zero =new Node(1,seven,two,1);

		return zero;
	}

	//Test. Should return 2 triangles
	public Node build_tree_int3() {

//		Node eleven = new Node(11, null, null, 4);
//		Node ten = new Node(10, eleven, null, 4);
//
//		Node eight = new Node(8, null, null, 4);
//
//		Node nine = new Node(9, ten, null, 4);
//
//		Node seven = new Node(7, eight, nine, 4);


		Node three = new Node(3, null, null, 3);
		Node four = new Node(4, null, null, 3);


		Node five = new Node(5, null, null, 3);
		Node six = new Node(6, null, null, 3);

		Node one = new Node(1, three, four, 2);
		Node two = new Node(2, five, six, 2);

		Node zero = new Node(0, one, two, 1);

		return zero;
	}

	//Test Case 1 from assignment sheet
	//Should return 2 Triangles
	public Node build_tree_int4() {
		Node three=new Node(3,null,null,3);
		Node four=new Node(4,null,null,4);

		Node five=new Node(5,null,null,3);
		Node six=new Node(6,null,null,3);

		Node seven=new Node(1,three,four,2);

		Node two=new Node(2,five,six,2);

		Node zero=new Node(0,seven,two,1);

		return zero;
	}

	//Test Case 2 from assignment sheet
	//Should return 6 Triangles
	public Node build_tree_int5() {
		Node eleven= new Node (11,null,null,4);

		Node ten=new Node(10,null,eleven,4);

		Node eight=new Node(8,null,null,4);
		Node nine=new Node(9,null,ten,4);

		Node seven=new Node(7,eight,nine,4);

		Node three=new Node(3,seven,eight,3);
		Node four=new Node(4,null,null,3);

		Node five=new Node(5,null,null,3);
		Node six= new Node(6,null,null,3);

		Node one=new Node(1,three,four,2);
		Node two=new Node(2,five,six,2);

		Node zero=new Node(0,one,two,1);

		return zero;
	}


	public void count_iso_triangle2(Node root) {
		//asserts when the tree is empty
		if (root==null) {
			throw new NullPointerException("Tree is empty");
		}
		else {
		  //initialize lwft and right
			int leftside=0;
			int rightside=0;

			//pointers
			Node next=root;
			Node current=next;

			while(next.r_child != null || current.l_child != null) {
			//if the right child and the left child are not null then breaks
				if(next==root && next.r_child != null) {
					//checks the right side of the tree and sets pointers and repeats through right side
					next=next.r_child;
					current=next;
					rightside+=1;
				}
				else if (current.l_child!=null) {
					//points to left child of the right child of the root
					current=current.l_child;
					leftside+=1;
					/*if both sides are equal then we know we have an isoceles triangle
					so add 1 to the total amount of iso triangles
					*/
					if(leftside==rightside) {
						total_iso_triangle+=1;
						}
				}

				///when the left child of the right child of the root is null
				else if (current.l_child==null) {
				//point to the right child of the left child of the root and iterate
					next=next.r_child;
					current=next;
					rightside+=1;
					leftside=0;
				}
			}

			//initializes
			leftside=0;
			rightside=0;

			//pointers
			next=root;
			current=next;

			while(next.l_child != null || current.r_child != null) {
				//if the left child or  right child are null
				if(next==root && next.l_child != null) {
					//checks if the next left child is not null and sets pointers and goes through left side
					next=next.l_child;
					current=next;
					leftside+=1;
				}


				//when the right child of the left child of the root is not null
				else if (current.r_child!=null) {
					//points to right child of the left child of the root
					current=current.r_child;
					rightside+=1;
					//if both sides are equal then we know we have an isoceles triangle
					if(leftside==rightside) {
						total_iso_triangle+=1;
					}
				}

				//when the right child of the left child of the root is null
				else if (current.r_child==null) {
					//point to the left child of the left child of the root and iterate left
					next=next.l_child;
					current=next;
					leftside+=1;
					rightside=0;
				}
			}
			//recursively calls the next level for left and right
			if (root.l_child != null)
				count_iso_triangle2(root.l_child);
			if (root.r_child != null)
				count_iso_triangle2(root.r_child);
		}
	}
	//main
	public static void main(String[] args) {
		IsoTriangle triangle =new IsoTriangle();
		Node root=triangle.build_tree_int();
		triangle.count_iso_triangle2(root);
		System.out.println(triangle.total_iso_triangle);
	}
}
