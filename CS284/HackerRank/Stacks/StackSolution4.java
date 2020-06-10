import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class StackSolution4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int[] y = new int[x];
        for(int y_i = 0; y_i < x; y_i++){
        y[y_i] = in.nextInt();
        }
        int max = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        int removedIndex;
            for (; i < x; i++) {
                if (stack.empty() || y[stack.peek()] <= y[i]) 
                    stack.push(i);
            else {
            while (!stack.empty() && y[stack.peek()] > y[i]) {
            removedIndex = stack.pop();
            if (stack.empty()) 
                max = Math.max(y[removedIndex] * i, max);
                else {
                max = Math.max(y[removedIndex] * (i - 1 - stack.peek()), max);
            }
            }   
            stack.push(i);
        }
        }

        while (!stack.empty()) {
        removedIndex = stack.pop();
        if (stack.empty()) {
            max = Math.max(y[removedIndex] * i, max);
        } else {
            max = Math.max(y[removedIndex] * (i - 1 - stack.peek()), max);
        }
        }

        System.out.println(max);
        in.close();
    }
}