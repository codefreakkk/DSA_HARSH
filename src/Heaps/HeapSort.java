package Heaps;

public class HeapSort {
    public void swap(int[] arr, int parent, int index) {
        int temp = arr[parent];
        arr[parent] = arr[index];
        arr[index] = temp;
    }

    public void heapify(int[] arr, int size, int index) {
        int largest = index;
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;

        if (leftIndex < size && arr[largest] < arr[leftIndex])
            largest = leftIndex;

        if (rightIndex < size && arr[largest] < arr[rightIndex])
            largest = rightIndex;

        if (largest != index) {
            swap(arr, largest, index);
            heapify(arr, size, largest);
        }
    }

    public void buildHeap(int[] arr) {
        int size = arr.length;
        for (int i = (size / 2) - 1; i >= 0; i--)
            heapify(arr, size, i);
    }

    public void heapSort(int[] arr) {
        int size = arr.length;
        buildHeap(arr);

        for (int i = size - 1; i > 0; i--) {
            swap(arr, i, 0);
            heapify(arr, i, 0);
        }
    }

    public void print(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] arr = {4,1,3,9,7};
        heapSort.heapSort(arr);
        heapSort.print(arr);
    }
}
