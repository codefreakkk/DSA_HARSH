package DSA_REVISION.heaps;

import java.util.*;

public class FindMedianFromDataStream {

    double median;
    PriorityQueue<Integer> minHeap, maxHeap;
    public FindMedianFromDataStream() {
        this.median = 0.0;
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    private int sigNum(int left, int right) {
        if (left == right) {
            return 0;
        }
        if (left > right) {
            return 1;
        }
        return -1;
    }

    public void addNum(int num) {
        int currentCase = sigNum(maxHeap.size(), minHeap.size());

        switch (currentCase) {
            case 0:
                if (num > median) {
                    minHeap.offer(num);
                    median = minHeap.peek();
                } else {
                    maxHeap.offer(num);
                    median = minHeap.peek();
                }
                break;

            case 1:
                if (num > median) {
                    minHeap.offer(num);
                    median = (minHeap.peek() + maxHeap.peek()) / 2;
                } else {
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(num);
                    median = (minHeap.peek() + maxHeap.peek()) / 2;
                }
                break;

            case -1:
                if (num > median) {
                    maxHeap.offer(minHeap.poll());
                    minHeap.offer(num);
                    median = (minHeap.peek() + maxHeap.peek()) / 2;
                } else {
                    maxHeap.offer(num);
                    median = (minHeap.peek() + maxHeap.peek()) / 2;
                }
                break;
        }
    }

    public double findMedian() {
        return median;
    }

}
