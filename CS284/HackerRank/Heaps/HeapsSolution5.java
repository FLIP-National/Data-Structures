import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class HeapsSolution5 {
    static final int max = 1000000;
    static int[] output = buildoutput();


public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        for (int i = 0; i < a; i++) {
            int b = sc.nextInt();

            System.out.println(solve(b));
        }
        sc.close();
    }

 static int[] buildoutput() {
        int[] output = new int[max + 1];
        for (int i = 1; i < output.length; i++) {
            output[i] = output[i - 1] + 1;

            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    output[i] = Math.min(output[i], output[i / j] + 1);
                }
            }
        }
        return output;
    }

    static int solve(int b) {
        return output[b];
    }
}