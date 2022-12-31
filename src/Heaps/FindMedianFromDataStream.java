package Heaps;

import java.util.*;

public class FindMedianFromDataStream {
    double median;
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public FindMedianFromDataStream() {
        median = 0.0;
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public int signum(int left, int right) {
        if (left == right)
            return 0;

        if (left > right)
            return 1;

        return -1;
    }

    public void addNum(int num) {
        callFindMedian(num);
    }

    public void callFindMedian(int num) {
        switch (signum(maxHeap.size(), minHeap.size())) {
            case 0:
                if (num > median) {
                    minHeap.offer(num);
                    median = minHeap.peek();
                }
                else {
                    maxHeap.offer(num);
                    median = maxHeap.peek();
                }
                break;

            case 1:
                if (num > median) {
                    minHeap.offer(num);
                    median = (maxHeap.peek() + minHeap.peek()) / 2.0;
                }
                else {
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(num);
                    median = (maxHeap.peek() + minHeap.peek()) / 2.0;
                }
                break;


            case -1:
                if (num > median) {
                    maxHeap.offer(minHeap.poll());
                    minHeap.offer(num);
                    median = (maxHeap.peek() + minHeap.peek()) / 2.0;
                }
                else {
                    maxHeap.offer(num);
                    median = (maxHeap.peek() + minHeap.peek()) / 2.0;
                }
                break;
        }
    }

    public double findMedian() {
        return median;
    }

    public static void main(String[] args) {

    }
}
