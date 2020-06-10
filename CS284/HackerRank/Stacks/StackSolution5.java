import java.io.*;
import java.util.*;

public class StackSolution5 {
  public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        String str = "";
        stack.push("");
        scanner.nextLine();
        for (int i = 0; i < x; i++) {
            int op = scanner.nextInt();
            switch (op) {

            //switch cases
            case 1:
                str = stack.peek() + scanner.next();
                stack.push(str);
                break;
            case 2:
                if (!stack.isEmpty()) {
                    str = stack.peek().substring(0, stack.peek().length() - scanner.nextInt());
                    stack.push(str);
                }
                break;
            case 3:
                if (!stack.isEmpty()) {
                    str = stack.peek();
                    char character = str.charAt(scanner.nextInt() - 1);
                    System.out.println(character);
                }
                break;
            case 4:
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                break;

            }
        }
        scanner.close();
    }

}