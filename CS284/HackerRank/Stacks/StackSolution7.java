import java.util.Scanner;
import java.util.Stack;

public class StackSolution7 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = "";
        stack.push("");
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            int inty = scanner.nextInt();
            switch (inty) {

            //switch casses
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
                    char c = str.charAt(scanner.nextInt() - 1);
                    System.out.println(c);
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