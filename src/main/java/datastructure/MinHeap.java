package datastructure;

import java.util.Arrays;
import java.util.HashMap;

/**
 * basic operation on min heap
 */
public class MinHeap {

    int[] minHeapArray;
    int size;
    int maxsize;
    int FRONT = 1;

    /**
     * initialize the size of heap
     *
     * @param maxsize int
     */
    public MinHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        this.minHeapArray = new int[this.maxsize + 1];
        minHeapArray[0] = Integer.MIN_VALUE;
    }

    private boolean isLeaf(int pos) {
        if (pos >= (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChile(int pos) {
        return pos * 2;
    }

    private int rightChild(int pos) {
        return (pos * 2) + 1;
    }

    private void insertMinHeap(int element) {
        if (size >= maxsize) {
            return;
        }
        minHeapArray[++size] = element;
        int current = size;
        while (minHeapArray[current] < minHeapArray[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }


    }

    private void swap(int i, int j) {
        int temp = minHeapArray[i];
        minHeapArray[i] = minHeapArray[j];
        minHeapArray[j] = temp;
    }

    /**
     * minHeap
     */
    private void minHeap() {
        for (int i = size / 2; i >= 0; i--) {
            minHeapUtil(i);
        }
    }

    private int remove() {
        int popped = minHeapArray[FRONT];
        minHeapArray[FRONT] = minHeapArray[size--];
        minHeapUtil(FRONT);
        return popped;
    }


    /**
     * minHeapUtil
     *
     * @param pos int
     */
    private void minHeapUtil(int pos) {
        if (minHeapArray[pos] > minHeapArray[leftChile(pos)] || minHeapArray[pos] > minHeapArray[rightChild(pos)]) {
            if (minHeapArray[leftChile(pos)] < minHeapArray[rightChild(pos)]) {
                swap(pos, leftChile(pos));
                minHeapUtil(leftChile(pos));
            } else {
                swap(pos, rightChild(pos));
                minHeapUtil(rightChild(pos));
            }

        }

    }

    /**
     * main
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("The Min Heap is ");
        MinHeap minHeap = new MinHeap(15);
        minHeap.insertMinHeap(2);
        minHeap.insertMinHeap(4);
        minHeap.insertMinHeap(7);
        minHeap.insertMinHeap(1);
        minHeap.insertMinHeap(5);
        minHeap.insertMinHeap(3);


        System.out.println(Arrays.toString(minHeap.minHeapArray));



    }

}
