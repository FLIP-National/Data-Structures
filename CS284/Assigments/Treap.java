/*Jessica Noel
 * CS284-C  Data Structures
 * Assignment 4
 * Treap
 */


import java.util.Random;

public class Treap<E extends Comparable<E>>{
	
	private static class Node<E> {
		//data fields
		public E data; // key for the search
		public int priority; //random heap priority
		public Node<E> left;
		public Node<E> right;
		
		
		//constructor
		public Node(E data, int priority) {
			if(data==null) {
				throw new NullPointerException("Data is null");
			}
			this.data=data;
			this.priority=priority;
			left=null;
			right=null;
		}

		//methods
		public Node<E> rotateRight(){
			//Rotates the Treap to the right and changes priority
			Node<E> temp=this.left;
			this.left=temp.right;
			this.right=this;
			return temp;
			//new data
		}

		public Node<E> rotateLeft(){
			//Rotates the treap to the left and changes priority
			Node<E> temp=this.right;
			this.right=this.left;
			this.left=this;
			return temp;
			//new data
		}
		public String toString() {
            return "(key="+this.data.toString()+", priority="+this.priority+")";
		}
	}
	
	//data fields
	private Random priorityGenerator;
	private Node<E> root;

	//constructors
	public Treap() {
		//makes the treap empty
		priorityGenerator=new Random();
		root=null;
	}

	public Treap(long seed) {
		//makes the treap empty
		priorityGenerator=new Random(seed);
		root=null;
	}

	
	//2.2.1
	
	
	/*Puts a node that has a random priority
	 * into the right spot of the treap
	 */
	//Returns true if key was successfully added to treap
	public boolean add(E key) {
		int after = priorityGenerator.nextInt();
		if(find(root, key) == true) {
			return false;
		//returns false if you can not add the key to the treap
		}
		if(after == 0) {
			return add(key);
		} 
		else {
			boolean res = add(key, after);
			return res;
		}
	}
	
	//helper for add
	private Node<E> addition(E key, int priority, Node<E> r) {
		if(r == null) {
			return new Node<E>(key, priority);
		}
		
		//when less than 0
		else if(key.compareTo(r.data) < 0) {
			r.left = addition(key, priority, r.left);
			if(r.left.priority > r.priority)
				r = r.rotateRight();
		} else if(key.compareTo(r.data) == 0) {
			return null;
		}
		else {
			r.right = addition(key, priority, r.right);
			if(r.right.priority > r.priority)
				r = r.rotateLeft();
		}
		return r;
	}
	
	
	public boolean add(E key, int priority) {
		if(find(root, key)) {
			return false;
		}
		Node<E> current = addition(key, priority, root);
		if(current == null) {
			return false;
		}
		root = current;
		return true;
	}

	
	//2.2.2
	
	//Deletes the node and changes the treap structure
	//Removes key from treap
	public Node<E> delete(E key) {
		int check = key.compareTo(root.data);
		if(check > 0){
			root.right = deleting(root.right, key);
		}
		return root;
		}
	
	private Node<E> deleting(Node<E> right, E key) {
		int check = key.compareTo(root.data);
		if(check > 0){
			root.right = deleting(root.right, key);
		}
		//when less than 0
		else if(check < 0){
			root.left = deleting(root.left, key);
		}
		//when right is equal to null
		else if(root.right == null){
			Node<E> newC = root.left;
			root = newC;
		}
		//when left is equal to null
		else if(root.left == null){
			Node<E> newC = root.right;
			root = newC;
		}
		//when right is greater than left rotate left then apply delete
		else if(root.right.priority > root.left.priority){
			root = root.rotateLeft();
			root.left = deleting(root.left, key);
		}
		//when right is greater than left rotate right and apply delete 
		else if(root.right.priority < root.left.priority){
			root = root.rotateRight();
			root.right = deleting(root.right, key);
		}
		return root;
	}


	//2.2.3
	
	//finds node that has the that key within the treap and returns that key #
	public boolean find(E key) {
		return find(this.root,key);
	}

	//asserts key to find and if not found
	//find helper
	public boolean find(Node<E> root, E key) {
		if(root != null) {
			int comp = key.compareTo(root.data);
			if(comp < 0) {
				return find(root.left, key);
			}
			if(comp > 0) {
				return find(root.right, key);
			} else {
				return true;
		}
		}
		return false;
	}
	
	//2.2.4
	public String toString() {
		StringBuilder string=new StringBuilder();
		orderT(root,1,string);
		return string.toString();
	}
	
	private void orderT(Node<E> current, int height, StringBuilder str) {
		int i;
		for(i = 1; i < height; i ++) {
			str.append(" ");
		}
		if(current == null) {
			str.append("null\n");
		}
		else {
			str.append(current.toString());
			str.append("\n");
			orderT(current.left, height + 1, str);
			orderT(current.right, height + 1, str);
		}
	}
	
public static void main(String[] args) {
	Treap<Integer> testTree=new Treap <Integer>();
	testTree.add(4 ,19);
	testTree.add(2 ,31);
	testTree.add(6 ,70);
	testTree.add(1 ,84);
	testTree.add(3 ,12);
	testTree.add(5 ,83);
	testTree.add(7 ,26);
	System.out.println(testTree);
}
}