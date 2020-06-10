import java.util.*;

public class MathExp {

    public Stack<Character> st = new Stack<>(); 
    public int closingParaIndex = 0;
	
	public boolean checkRedun(String s) {
        
		char[] str = s.toCharArray(); 
		//iterate
		for (char ch : str) { 

			// if current character is close parenthesis ')' 
			if (ch == ')') { 
				char top = st.peek(); 
				st.pop(); 

				// If theres (( there's a dupe 
				boolean err = true; 

				while (top != '(') {
					//If there's operators, then there are not redundant paren 
					if (top == '+' || top == '-'
							|| top == '*' || top == '/') { 
						err = false; 
					}
					//show and take out top of stack
					top = st.peek(); 
					st.pop(); 
				} 

				//operators not found so theres dupe
				if (err == true) {
					return true; 
				} 
			} else { 
                closingParaIndex++;
                // push ( and operators to stack 
				st.push(ch);
			}	
		} 
		return false; 
    } 

    public String rm_redun_paren(String expr) {

        System.out.println("\nInput string: " + expr);
        StringBuilder sb = new StringBuilder(expr);
        
        //checks if there are redundancies
        while(checkRedun(expr) == true) {
        
        	//increment the index by 1 for each stacked character
        	//get length of stack, which is the opening index.
            sb.deleteCharAt(closingParaIndex+1);
            sb.deleteCharAt(st.size());        
            expr = sb.toString();

            closingParaIndex = 0;
            // System.out.println(closingParaIndex);
        }

        //repeats
        return sb.toString();

    }
    
    public static void main(String[] args) {
        MathExp m = new MathExp();
        System.out.println("Removed redundancies: " +  m.rm_redun_paren("(((a+b)+(c+d)))"));
    }
}
   