import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class StackSolution3 {

    /*
     * Complete the equalStacks function below.
     */
    static int equalStacks(int[] h1, int[] h2, int[] h3) {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        Stack<Integer> stack3 = new Stack<Integer>();
        int stack1TotalHeight = 0, stack2TotalHeight = 0, stack3TotalHeight = 0;

        // pushing height to stack
        for (int i = h1.length - 1; i >= 0; i--) {
            stack1TotalHeight += h1[i];
            stack1.push(stack1TotalHeight);
        }
        for (int i = h2.length - 1; i >= 0; i--) {
            stack2TotalHeight += h2[i];
            stack2.push(stack2TotalHeight);
        }
        for (int i = h3.length - 1; i >= 0; i--) {
            stack3TotalHeight += h3[i];
            stack3.push(stack3TotalHeight);
        }

        while (true) {
            //empty
            if (stack1.isEmpty() || stack2.isEmpty() || stack3.isEmpty())
                return 0;
                stack1TotalHeight = stack1.peek();
                stack2TotalHeight = stack2.peek();
                stack3TotalHeight = stack3.peek();
            //equal sum
            if (stack1TotalHeight == stack2TotalHeight && stack2TotalHeight == stack3TotalHeight) return stack1TotalHeight;

            if (stack1TotalHeight >= stack2TotalHeight && stack1TotalHeight >= stack3TotalHeight) stack1.pop();
            else if (stack2TotalHeight >= stack1TotalHeight && stack2TotalHeight >= stack3TotalHeight) stack2.pop();
            else if (stack3TotalHeight >= stack2TotalHeight && stack3TotalHeight >= stack1TotalHeight) stack3.pop();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();
        int h1[] = new int[n1];
        for (int h1_i = 0; h1_i < n1; h1_i++) {
            h1[h1_i] = in.nextInt();
        }
        int h2[] = new int[n2];
        for (int h2_i = 0; h2_i < n2; h2_i++) {
            h2[h2_i] = in.nextInt();
        }
        int h3[] = new int[n3];
        for (int h3_i = 0; h3_i < n3; h3_i++) {
            h3[h3_i] = in.nextInt();
        }
        System.out.println(equalStacks(h1, h2, h3));
        in.close();
    }
}