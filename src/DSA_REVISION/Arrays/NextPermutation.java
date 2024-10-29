package DSA_REVISION.Arrays;

public class NextPermutation {


    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public void nextPermutation(int[] nums) {
        int size = nums.length, index = -1;

        for (int i = size - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }

        // edge case
        if (index == -1) {
            reverse(nums, 0, size - 1);
            return;
        }

        for (int i = size - 1; i > index; i--) {
            if (nums[i] > nums[index]) {
                swap(nums, i, index);
                break;
            }
        }
        reverse(nums, index + 1, size - 1);
    }

    public static void main(String[] args) {

    }
}
