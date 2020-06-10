import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Collections;

public class HeapsSolution2 {
    //sort and track min numbers
    //sort and track max numbers
    private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); 
    private static PriorityQueue<Integer> minHeap = new PriorityQueue<>();               
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int [] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scan.nextInt();
        }
        scan.close();
       findMedian(array);
    }

      //ensure max heap has more elements than min
    private static double getMedian() {
        if (maxHeap.isEmpty()) {
            return 0;
        } else if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }

    private static void add(int n) {
        if (maxHeap.isEmpty()) {
            maxHeap.add(n);
        } else if (maxHeap.size() == minHeap.size()) {
            if (n < minHeap.peek()) {
                maxHeap.add(n);
            } else {
                maxHeap.add(minHeap.remove());
                minHeap.add(n);
            }
            //max heap must be greater than min
        } else if (maxHeap.size() > minHeap.size()) {
            if (n > maxHeap.peek()) {
                minHeap.add(n);
            } else {
                maxHeap.add(n);
                minHeap.add(maxHeap.remove());
            }
        }
    }
        public static void findMedian(int [] array) {
        for (int i = 0; i < array.length; i++) {
            add(array[i]);
            System.out.println(getMedian());
        }
    }
}