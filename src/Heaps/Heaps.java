package Heaps;

class MaxHeap {
    int size;
    int[] arr;

    public MaxHeap() {
        this.size = 0;
        this.arr = new int[100];
    }
    public void swap(int parent, int index) {
        int temp = arr[parent];
        arr[parent] = arr[index];
        arr[index] = temp;
    }
    public void print() {
        for (int i = 1; i <= size; i++)
            System.out.print(arr[i] + " ");
    }

    // insertion in max heap
    public void insert(int data) {
        size++;
        int index = size;

        // insert at end of array
        arr[index] = data;

        // rebuild tree
        while (index > 1) {
            int parent = index / 2;

            if (arr[parent] < arr[index]) {
                swap(parent, index);
                index = parent;
            }
            else
                return;
        }
    }

    // deletion in max heap
    public void delete() {
        arr[1] = arr[size];
        size--;

        int i = 1;
        while (i < size) {
            int leftIndex = 2 * i;
            int rightIndex = 2 * i + 1;

            if (leftIndex < size && arr[i] < arr[leftIndex]) {
                swap(i, leftIndex);
                i = leftIndex;
            }
            else if (rightIndex < size && arr[i] < arr[rightIndex]) {
                swap(i, rightIndex);
                i = rightIndex;
            }
            else
                return;
        }
    }

}

public class Heaps {
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(50);
        maxHeap.insert(55);
        maxHeap.insert(53);
        maxHeap.insert(52);
        maxHeap.insert(54);
        maxHeap.print();
        maxHeap.delete();
        System.out.println();
        maxHeap.print();
    }
}
