package datastructure;

import java.util.Arrays;

public class MaxHeap {

    int MAX_SIZE;
    int size;
    int[] maxHeapArray;

    public MaxHeap(int maxSize) {
        this.MAX_SIZE = maxSize;
        this.size = 0;
        this.maxHeapArray = new int[MAX_SIZE + 1];
        this.maxHeapArray[this.size] = Integer.MAX_VALUE;
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

    private void swap(int i, int j) {
        int temp = maxHeapArray[i];
        maxHeapArray[i] = maxHeapArray[j];
        maxHeapArray[j] = temp;
    }

    private void insert(int element) {
        if (size > MAX_SIZE) {
            return;
        }
        maxHeapArray[++size] = element;
        int current = size;

        while (maxHeapArray[current] > maxHeapArray[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }


    private void maxHeapUtil(int pos) {
        if (maxHeapArray[pos] < maxHeapArray[leftChile(pos)] ||
                maxHeapArray[pos] < maxHeapArray[rightChild(pos)]) {
            if (maxHeapArray[leftChile(pos)] > maxHeapArray[rightChild(pos)]) {
                swap(pos, leftChile(pos));
                maxHeapUtil(leftChile(pos));
            } else {
                swap(pos, rightChild(pos));
                maxHeapUtil(rightChild(pos));
            }
        }
    }

    private void maxHeap() {
        for (int i = size / 2; i >= 1; i--) {
            maxHeapUtil(i);
        }
    }


    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(15);
        System.out.println("The Max Heap is ");
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);

        System.out.println(Arrays.toString(maxHeap.maxHeapArray));

        maxHeap.maxHeap();
    }
}
