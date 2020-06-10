import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ArraySolution3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int[] a = new int[x];
        for (int i = 0; i < a.length; i++) {
            a[i] = scanner.nextInt();
        }

        int[] rotated = rotate(a, y);
        for (int i = 0; i < rotated.length; i++) {
            if (i != 0) {
                System.out.print(" ");
            }
            System.out.print(rotated[i]);
        }
        System.out.println();

        scanner.close();
    }

    static int[] rotate(int[] a, int y) {
        int[] rotated = new int[a.length];
        for (int i = 0; i < rotated.length; i++) {
            rotated[i] = a[(i + y) % a.length];
        }
        return rotated;
    }
}