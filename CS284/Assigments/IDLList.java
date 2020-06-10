/*Jessica Noel
 * I pledge my honor that I have abided by the Stevens Honor System.
 * Assignment 2
 * CS 284, Professor Xu
 */

package BinaryNumber;

import java.util.ArrayList;

public class IDLList<E> {
	
	private class Node<E> {
		private E data;
		private Node<E> next;
		private Node<E> prev;
		
		Node(E elem) {
			data=elem;
			next=null;
			prev=null;
		}
		Node(E elem, Node<E> prev, Node<E> next) {
			this.data=elem;
			this.next=next;
			this.prev=prev;	
		}
		E getData() {
			return data;
		}
	}
	
	private Node<E> head;
	private Node<E> tail;
	private int size;
	private ArrayList<Node<E>> indices;
	
	public IDLList() {
		//creates an empty double-linked list
		head=null;
		tail=null;
		indices=new ArrayList<Node<E>>();
	}
	
	public boolean add(int index, E elem){
		//adds elem at position index and always returns true
		Node<E> newn = new Node<E>(elem);
		if (index < 0) {
			   System.out.println("Error: Index less than 0!");
		}   else if (index > size) {
			   System.out.println("Error: index greater than size!");
			}
		if (index==0) {
			head = newn;
			size++;
			indices.add(newn);
		}
		Node<E> cur=head;
		for (int i=0; i<index; i++) {
			cur=cur.next;
		}
		cur = head.next;
		head.next = newn;
		head = head.next;
		head.next = cur;
		size++;
		return true;
	}
	
	public E get(int index) {
		Node<E> x=head;
		if (head==null) {
			return null;
		}
			else if (index>= size) {
			return null;
		}
			else if(index==0) {
				return x.getData();
			}
			else {
				for(int i=0;i<index;i++) {
					x=x.next;
				}
			}
			return x.getData();
	}
	
	
	public boolean add(E elem) {
		//adds elem at the head (becomes the first elements of the list) and always returns true
		Node<E> new_node=new Node<E>(elem); 
		if(head==null) {
			head=new_node;
			size++;
			indices.add(new_node);
		}
		else {
		new_node.next=head;
		head=new_node;
		}
		return true;
	}
	
	public boolean append(E elem) {
		//adds elem as the new last element of the list and always returns true
		Node<E> new_node=new Node(elem);
		if(head==null) {
			head=new_node;
		}
		else {
			new_node.next=head;
			new_node.prev=null;
			if(head!=null) {
				head.prev=new_node;
				head=new_node;
		}
		}
		return true;
	}
	
	public E getHead() {
		//returns the object at the head
		if (head==null) {
			throw new IllegalStateException();
		}
		else {
			return head.data;
		}
	}
	
	public E getLast() {
		//returns the object at the tail
			return tail.getData();
	}
	
	public int size() {
		//returns the list size
		int size=indices.size();
		return size;
	}
	
	public E remove() {
		//Throws an exception if there is no such element 
		if (head==null) { 
			throw new IllegalStateException("There is no element!");
		}
		//removes and returns the element at the head
		else {
			E x=head.data;
			head=head.next;
			size--;
			return x;
		}
	}
	
	public E removeLast() {
		//removes and returns the element at the tail
		//Throws an exception if there is no such element
		if (head==tail) {
			head=null;
			tail=null;
		throw new IllegalStateException();
		} else {
			Node<E> cur=head;
			while (cur.next!=tail) {
				cur=cur.next;
			}
			cur.next=null;
			tail=cur;
		  }
		return tail.getData();
	}
	
	public E removeAt(int index) {
		//throws an exception if there is no such element
		if (index <0) {
			throw new IllegalStateException("Index is less than 0!");
		}
		if (index>size) {
			throw new IllegalStateException("Index exceeds size!");
		}
		//removes and returns the element at the index "index"
		if (index==0) {
			return remove();
		}
		if (index==size-1) {
			return removeLast();
		}
		Node<E> cur=indices.remove(index);
		cur.prev.next=cur.next;
		cur.next.prev=cur.prev;
		size--;
		return cur.data;
	}
	
	public boolean remove(E elem) {
		//returns true if elem is in list and returns false if elem is not
		Node<E> x= head;
		if(head==null && head.next==null) {
			return false;
		}
		while (head.next!=null) {
			if(head.getData()==elem) {
				this.remove();
				return true;
			}
			head=head.next;
		}
		return false;
			}
		
	public String toString() {
		//presents a string representation of the list
		String str="";
		if (head==null) {
			return "Empty!";
		}
		Node<E> cur=head;
		while(cur.next != null) {
			str+=cur.getData();
			cur=cur.next;
		}
		str+=cur.getData();
		return str;
	}	
   }	
