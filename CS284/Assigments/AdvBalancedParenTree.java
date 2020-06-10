package BinaryNumber;
import java.util.ArrayList;
import java.util.Stack;



public class AdvBalancedParenTree {


	    
		private class Node {
	        private String terminal;
	        private Node[] children;

	        private Node() {
	            this.terminal = null;
	            this.children = null;
	        }

	        private Node(String terminal, Node[] children) {
	            this.terminal = terminal;
	            this.children = children;
	        }
	    }

	    public Node root;


	    public AdvBalancedParenTree() {
			// TODO Auto-generated constructor stub
		}

		public void go(String p) throws Exception {
	        Node root = new Node(null, parse(p, null));
	        this.root = root;
	        System.out.println(print(this.root));
	    }

	    public Node[] parse(String paren_str, String mountainSequence) throws Exception {
	        
	        // First iteration 
	        if(mountainSequence == null) {
	            if(!isBalanced(paren_str)) {
	                throw new Exception("Not balanced");
	            }

	            char[] symbols = paren_str.toCharArray();
	            mountainSequence = "0";

	            int sequence = 0;
	            for(int i=0; i < symbols.length; i++) {
	            	if((symbols[i] == '(') || (symbols[i] == '[')) {
	                    sequence++;
	                    mountainSequence += sequence;
	                }
	                else if((symbols[i] == ')') || (symbols[i] == ']')) {
	                    sequence--;
	                    mountainSequence += sequence;
	                }        
	            }
	        }

	        int parentCount = 1;
	        for (int i = 1; i < mountainSequence.length()-1; i++) {
	            if (mountainSequence.charAt(i) == '0') {
	                parentCount++;
	            }
	        }

	        ArrayList<Integer> zeros = new ArrayList<Integer>();
	        char[] mountainChars = mountainSequence.toCharArray();

	        for (int i = 1; i < mountainChars.length - 1; i++) {
	            if (mountainChars[i] == mountainChars[0]) {
	                zeros.add(i);
	            }
	        }
	        System.out.println(parentCount);

	        // Rule 1 
	        if(parentCount > 1) {
	            Node[] n = new Node[zeros.size() + 1];
				n[0] = new Node(null, parse(paren_str,mountainSequence.substring(0, zeros.get(0) + 1)));
	            
	            int index = 1;
				while (index < zeros.size()) {
					n[index] = new Node(null, parse(paren_str,mountainSequence.substring(zeros.get(index - 1), zeros.get(index) + 1)));
					index++;
				}
				n[zeros.size()] = new Node(null, parse(paren_str,mountainSequence.substring(zeros.get(index - 1), mountainChars.length)));
				return n;
	        }
	        // Rule 2
	        else {
	            if (mountainSequence.length() == 1)
	                    return null;
	                String mountainStripped = mountainSequence.substring(1, mountainSequence.length() - 1);
	                Node[] n = new Node[3];
	                n[0] = new Node("(", null);
	                n[1] = new Node(null, parse(paren_str, mountainStripped));
	                n[2] = new Node(")", null);

	            return n;
	        }
	            }

	    public String print(Node n) {

	        if (n.terminal != null) {
	            return n.terminal;
	        }
			else if (n.children == null) {
	            return "";
	        }
	        else {
	            String traversal = "";
	            for(int i=0; i < n.children.length; i++)
	                traversal += print(n.children[i]);
	            return traversal;
	        }
	    }

	    public static boolean isBalanced(String expression) {
			Stack<Integer> s = new Stack<Integer>();
			int index = 0;
			while (index < expression.length()) {
				char nextCh = expression.charAt(index);
				if (nextCh == '(') {
					s.push(1);
				} else if (nextCh == ')') {
					try {
						s.pop();
					} catch (Exception e) {
						return false;
					}
				}
				index++;
			}
			return s.empty();
		}

	    public static void main(String[] args) throws Exception{
	        AdvBalancedParenTree b = new AdvBalancedParenTree();
	        b.go("[()]");
	    }
	}
