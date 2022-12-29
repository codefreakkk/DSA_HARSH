package Heaps;

public class Heapify {
    public void swap(int[] arr, int parent, int index) {
        int temp = arr[parent];
        arr[parent] = arr[index];
        arr[index] = temp;
    }

    // heapify for max heap
    public void maxHeapHeapify(int[] arr, int size, int index) {
        int largest = index;
        int leftIndex = 2 * index;
        int rightIndex = 2 * index + 1;

        if (leftIndex <= size && arr[largest] < arr[leftIndex])
            largest = leftIndex;

        if (rightIndex <= size && arr[largest] < arr[rightIndex])
            largest = rightIndex;

        if (largest != index) {
            swap(arr, largest, index);
            maxHeapHeapify(arr, size, largest);
        }
    }

    public void buildTreeMaxHeap(int[] arr, int size) {
        for (int i = size / 2; i > 0; i--)
            maxHeapHeapify(arr, size, i);
    }


    // heapify for min heap
    public void minHeapHeapify(int[] arr, int size, int index) {
        int smallest = index;
        int leftIndex = 2 * index;
        int rightIndex = 2 * index + 1;

        if (leftIndex <= size && arr[smallest] > arr[leftIndex])
            smallest = leftIndex;

        if (rightIndex <= size && arr[smallest] > arr[rightIndex])
            smallest = rightIndex;

        if (smallest != index) {
            swap(arr, smallest, index);
            minHeapHeapify(arr, size, smallest);
        }
    }

    public void buildTreeMinHeap(int[] arr, int size) {
        for (int i = size / 2 ; i > 0; i--)
            minHeapHeapify(arr, size, i);
    }

    public void print(int[] arr, int size) {
        for (int i = 1; i <= size; i++)
            System.out.print(arr[i] + " ");
    }
    public static void main(String[] args) {
        Heapify heapify = new Heapify();
        int[] arr = {-1, 54, 53, 55, 52, 50};
        int size = 5;
//        heapify.buildTreeMaxHeap(arr, size);
        heapify.buildTreeMinHeap(arr, size);
        heapify.print(arr, size);
    }
}
