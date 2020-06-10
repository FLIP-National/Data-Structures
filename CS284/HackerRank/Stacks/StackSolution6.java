import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class StackSolution6 {
    public static ArrayList<Integer> findNPrimes(int n) {
    ArrayList<Integer> lst = new ArrayList<Integer>();
    int i = 2;
        while (lst.size() < n) {
        BigInteger temp = new BigInteger("" + i);
            if (temp.isProbablePrime(1000)) lst.add(i);
                i++;
        }
        return lst;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        Stack<Integer> stackOne = new Stack<Integer>();
        ArrayList<Integer> lst = findNPrimes(b);
        for (int i = 0; i < a; i++) {
            stackOne.push(in.nextInt());
        }
        ArrayList<Stack<Integer>> stack = new ArrayList<Stack<Integer>>();
            for (int i = 0; i < b; i++) {
                Stack<Integer> tempA = new Stack<Integer>();
                Stack<Integer> tempp = new Stack<Integer>();
                while (!stackOne.empty()) {
                    if (stackOne.peek() % lst.get(i) == 0) tempp.push(stackOne.pop());
                    else {
                        tempA.push(stackOne.pop());
                    }
                }   
                stack.add(tempp);
                stackOne = tempA;
                }
                for (int i = 0; i < b; i++) {
                    while (!stack.get(i).empty()) {
                        System.out.println(stack.get(i).pop());
                    }
                }

                while (!stackOne.empty()) {
                    System.out.println(stackOne.pop());
                }
        }
    }  