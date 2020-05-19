package algorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianStream {
    public static void main(String[] args) {
        int[] arr_2 = {5,10,1,3,7,8,2};
        int[] expected_2 = {2, 3, 4, 3, 4, 3};
        int[] output_2 = findMedian(arr_2);
        System.out.println(Arrays.toString(output_2));

    }

    static int[] findMedian(int[] arr) {
        if (arr.length == 0) {
            return arr;
        }
        int[] result = new int[arr.length];

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int midian = arr[0];
        minHeap.add(arr[0]);
        result[0] = midian;

        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            if (maxHeap.size() > minHeap.size()) {
                if (current < midian) {
                    minHeap.add(maxHeap.remove());
                    maxHeap.add(current);
                } else {
                    minHeap.add(current);
                }
                midian = (minHeap.peek() + maxHeap.peek()) / 2;

            } else if (maxHeap.size() < minHeap.size()) {
                if (current > midian) {
                    maxHeap.add(minHeap.poll());
                    minHeap.add(current);
                } else {
                    maxHeap.add(current);
                }
                midian = (minHeap.peek() + maxHeap.peek()) / 2;

            } else {
                if (current < midian) {
                    maxHeap.add(current);
                    midian = maxHeap.peek();
                } else {
                    minHeap.add(current);
                    midian = minHeap.peek();
                }

            }
            result[i] = midian;
        }
        return result;
    }
}
