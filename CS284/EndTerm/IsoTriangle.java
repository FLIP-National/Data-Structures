/*JESSICA NOEL
 * CS 284 ENDTERM
 * PROBLEM 2
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IsoTriangle {
	

	protected class Node {
		
		int value;
		
		Node l_child;
		Node r_child;

		
		Integer depth;
		
		private Node(int value, Node l_child, Node r_child) {
			this.value = value;
			this.l_child = l_child;
			this.r_child = r_child;
		}
		
		private Node(int value, Node l_child, Node r_child, int depth) {
			this.value = value;
			this.l_child = l_child;
			this.r_child = r_child;
			this.depth = depth;
		}
	}
	
	public Node build_tree_int() {
		Node zero = new Node(4, null, null, 2);
		Node two = new Node(6, null, null, 3);
		
		Node four = new Node(2, null, null, 4);
		Node six = new Node(5, null, null, 4);
		
		Node five = new Node(0, four, six, 3);
		Node three = new Node(1, two, five, 2);
		
		Node one = new Node(3, zero, three, 1);
		
		return one;
	}
	
	public Node build_tree_int2() {
		
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
	
	//Test Case 1
	public Node build_tree_int3() {
		Node three = new Node(3, null,null,3);
		Node four = new Node(4, null, null, 3);
		
		Node five= new Node(5, null, null, 3);
		Node six= new Node(6, null, null, 3);
		
		Node seven= new Node(7, three, four, 2);
		Node two= new Node(2, five, six, 2);
		
		Node ten=new Node(10, seven, two, 2);
		
		return ten;
	}
	
	//Test Case 2
	public Node build_tree_int4() {
		
		Node five= new Node(5,null,null,4);
		Node two= new Node(2,null,null,4);
		
		Node zero= new Node(0, two,five,3);
		Node six= new Node(6, null,null,3);
		
		Node one=new Node(1,six,zero,2);
		Node four=new Node(4,null,null,2);
		
		Node three=new Node(3,four,one,1);
		
		return three;
	}

	Integer left_max_segment_node1=0;
	Integer left_max_segment_node2=0;
	Integer right_max_segment_node1=0;
	Integer right_max_segment_node2=0;
	Integer max_segment_val=0;
	Integer leftMax=0;
	Integer rightMax=0;
	Integer max_segment_node1=0;
	Integer max_segment_node2=0;
	
	public Node root;
	
	public IsoTriangle() {
		root=null;
	}
	
	public int leftHelper(Node temp) {
		//if tree is empty
		if(temp==null) {
		return 0;
		}
		Node currentnode=temp;
		//makes an array which stores all left node values
		List<Integer> leftList= new ArrayList<Integer>();
		while (currentnode!=null) {
			leftList.add(currentnode.value);
			currentnode=currentnode.l_child;
		}
		if (leftList.size()<2) {
			return 0;
		}
		//reverses the array so that its sorted from greatest number to least
		Collections.sort(leftList, Collections.reverseOrder());
		//gets the first and second greatest left side nodes by their index
		left_max_segment_node1=leftList.get(0);
		left_max_segment_node2=leftList.get(1);
		
		//adds the two greatest nodes and sets that to the left max sum
		leftMax=left_max_segment_node1+left_max_segment_node2;
		
		return leftMax;
	}
		

		public int rightHelper(Node temp) {
			//if tree is empty
			if(temp==null) {
			return 0;
			}
			Node currentnode=temp;
			//makes an array which stores all right node values
			List<Integer> rightList= new ArrayList<Integer>();
			while (currentnode!=null) {
				rightList.add(currentnode.value);
				currentnode=currentnode.r_child;
			}
			if (rightList.size()<2) {
				return 0;
			}
			//reverses the array so that its sorted from greatest number to least
			Collections.sort(rightList, Collections.reverseOrder());
			//gets the first and second greatest right side nodes by their index
			right_max_segment_node1=rightList.get(0);
			right_max_segment_node2=rightList.get(1);
			
			//adds the two greatest nodes and sets that to the right max sum
			rightMax=right_max_segment_node1+right_max_segment_node2;
			
			return rightMax;
		
		}
		
		public int max_segment(Node root) {
			leftMax=leftHelper(root);
			rightMax=rightHelper(root);
		
		//if the left max is greater than the global max then set the new max = to left max and set the max nodes equal to left max nodes
		if (leftMax>max_segment_val) {
			max_segment_val=leftMax;
			max_segment_node1=left_max_segment_node1;
			max_segment_node2=left_max_segment_node2;
		}
		//if the right max is greater than the global max then set the new max = to right max and set the max nodes equal to right max nodes
		if (rightMax>max_segment_val) {
			max_segment_val=rightMax;
			max_segment_node1=right_max_segment_node1;
			max_segment_node2=right_max_segment_node2;
		}
		return max_segment_val;
		}

	//test and print outs.
	public void test_max_segment() {
		root = build_tree_int3();
		max_segment(root);
		System.out.println("max segment:"+ max_segment_val);
		System.out.println("max segment node 1:" + max_segment_node1);
		System.out.println("max segment node 2:" + max_segment_node2);
	}
	
	//main method
	public static void main(String args[]) {
		IsoTriangle test= new IsoTriangle();
		test.test_max_segment();
	}
}

