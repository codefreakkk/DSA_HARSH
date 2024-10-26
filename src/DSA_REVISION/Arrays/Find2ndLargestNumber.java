package DSA_REVISION.Arrays;

public class Find2ndLargestNumber {

    public int getSecondLargestElement(int[] nums) {
        int length = nums.length, secondLargest = -1, largest = -1;

        for (int i = 0; i < length; i++) {
            if (nums[i] > largest) {
                largest = nums[i];
                secondLargest = largest;
            }
            else if (nums[i] > secondLargest && nums[i] < largest) {
                secondLargest = nums[i];
            }
        }
        if (secondLargest == -1) {
            return -1;
        }
        return secondLargest;
    }

    public static void main(String[] args) {

    }
}
