import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ArraySolution2 {

	
	
	/* MY
	 * CODE
	 * STARTS
	 * HERE
	 */
	
    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int column=arr.length;
        int row=arr[0].length;

        int maxSum=Integer.MIN_VALUE;

        for(int i=0; i<row-2; i++) {
            for(int j=0; j<column-2; j++) {
                int sum= arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i+1][j+1]+arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2];
                maxSum=Math.max(maxSum, sum);
            } 
        }
        return maxSum;
    }
    /* MY
     * CODE
     * ENDS
     * HERE
     */

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}