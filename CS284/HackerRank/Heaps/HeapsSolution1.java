import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class HeapsSolution1 {

    private static int cookies(long k,PriorityQueue<Integer> queue){
    int count=0;
    while(queue.peek()<k) {
      if(queue.size()>=2) {
        count++;
        int a = queue.poll();
        int b = queue.poll();
        queue.offer(a+(b*2));
      }
      else {
        return -1;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int cookies = scan.nextInt();
    long min = scan.nextLong();
    PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
    for(int i=0;i<cookies;i++) {
      queue.offer(scan.nextInt());
    }
    System.out.println(cookies(min,queue));
  }

}