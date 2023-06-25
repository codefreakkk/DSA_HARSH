package REVISION.Heaps;

public class Heaps {

    private int size = 0;
    private int[] nums;

    public Heaps(int size) {
        this.size = 0;
        this.nums = new int[size + 1];
    }

    private void swap(int parent, int index) {
        int temp = nums[parent];
        nums[parent] = nums[index];
        nums[index] = temp;
    }

    private void print() {
        for (int i = 1; i <= size; i++) {
            System.out.println(nums[i]);
        }
        System.out.println("*******");
    }

    public void insert(int data) {
        size++;
        int index = size;

        nums[index] = data;

        while (index > 1) {
            int parent = index / 2;

            if (nums[parent] < nums[index]) {
                swap(parent, index);
                index = parent;
            }
            else return;
        }
    }

    public void delete() {
        nums[1] = nums[size];
        size--;

        int i = 1;
        while (i < size) {
            int leftIndex = 2 * i;
            int rightIndex = 2 * i + 1;

            if (leftIndex <= size && nums[i] < nums[leftIndex]) {
                swap(i, leftIndex);
                i = leftIndex;
            }
            else if (rightIndex <= size && nums[i] < nums[rightIndex]) {
                swap(i, rightIndex);
                i= rightIndex;
            }
            else return;
        }
    }

    public static void main(String[] args) {
        Heaps heap = new Heaps(5);
        heap.insert(10);
        heap.insert(20);
        heap.insert(30);
        heap.insert(40);
        heap.insert(50);
        heap.print();
        heap.delete();
        heap.print();
    }
}
