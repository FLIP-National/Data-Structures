import java.io.*;
import java.util.*;

public class StackSolution2 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        Stack<Integer> stackOne = new Stack<>();
        Stack<Integer> StackTwo = new Stack<>();
        StackTwo.push(Integer.MIN_VALUE);

        for (int i = 0; i < x; i++) {
            int op = scan.nextInt();
            switch (op) {

            //USE SWITCH STATEMENTS
            case 1:
                int n = scan.nextInt();
                stackOne.push(n);
                int maxSoFar = StackTwo.peek();
                if (n > maxSoFar) {
                    StackTwo.push(n);
                } else {
                    StackTwo.push(maxSoFar);
                }
                break;
            case 2:
                stackOne.pop();
                StackTwo.pop();
                break;
            case 3:
                System.out.println(StackTwo.peek());
                break;
            }
        }
        scan.close();
    }
}