package REVISION.stack;

public class NStacksInArray {

    int[] arr, top, next;
    int freespot;

    public NStacksInArray(int N, int S) {
        this.arr = new int[N];
        this.next = new int[N];
        this.top = new int[S];
        this.freespot = 0;
    }

    public boolean push(int x, int m) {
        if (freespot == -1) {
            return false;
        }

        int index = freespot;
        freespot = next[index];
        arr[index] = x;
        next[index] = top[m - 1];
        top[m - 1] = index;
        return true;
    }

    public int pop(int m) {
        if (top[m - 1] == -1) {
            return -1;
        }

        int index = top[m - 1];
        top[m - 1] = next[index];
        next[index] = freespot;
        freespot = index;
        return arr[index];
    }


}
