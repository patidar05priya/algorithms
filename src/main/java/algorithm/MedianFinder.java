package algorithm;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

    double mid = 0.0;

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public static void main(String[] args) {
        // Your MedianFinder object will be instantiated and called as such:
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        obj.addNum(2);

        System.out.println(obj.findMedian());

        double param_2 = obj.findMedian();

    }

    public MedianFinder() {

    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() && minHeap.isEmpty()) {
            minHeap.add(num);
            mid = num;
        } else {
            if (maxHeap.size() > minHeap.size()) {
                if (num < mid) {
                    minHeap.add(maxHeap.remove());
                    maxHeap.add(num);
                } else {
                    minHeap.add(num);
                }
                mid = ((double)minHeap.peek() + maxHeap.peek()) / 2;

            } else if (maxHeap.size() < minHeap.size()) {
                if (num > mid) {
                    maxHeap.add(minHeap.poll());
                    minHeap.add(num);
                } else {
                    maxHeap.add(num);
                }
                mid = ((double) minHeap.peek() + maxHeap.peek()) / 2;

            } else {
                if (num < mid) {
                    maxHeap.add(num);
                    mid = maxHeap.peek();
                } else {
                    minHeap.add(num);
                    mid = minHeap.peek();
                }

            }
        }

    }

    public double findMedian() {
        return mid;

    }
}
