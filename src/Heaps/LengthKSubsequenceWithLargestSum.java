package Heaps;
import java.util.*;
public class LengthKSubsequenceWithLargestSum {
    class Pairs {
        int data, index;
        public Pairs(int data, int index) {
            this.data = data;
            this.index = index;
        }
    }

    public int[] maxSubsequence(int[] nums, int k) {
        int size = nums.length;
        PriorityQueue<Pairs> pq = new PriorityQueue<>(new Comparator<Pairs>() {
            @Override
            public int compare(Pairs o1, Pairs o2) {
                return o1.data - o2.data;
            }
        });

        for (int i = 0; i < size; i++) {
            pq.offer(new Pairs(nums[i], i));
            if (pq.size() > k)
                pq.poll();
        }

        Set<Integer> set = new HashSet<>();
        while (!pq.isEmpty()) {
            Pairs pair = pq.poll();
            set.add(pair.index);
        }

        int[] result = new int[set.size()];
        int resultIndex = 0;
        for (int i = 0; i < size; i++) {
            if (set.contains(i)) {
                result[resultIndex] = nums[i];
                resultIndex++;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        LengthKSubsequenceWithLargestSum o = new LengthKSubsequenceWithLargestSum();
        int[] nums = {3,4,3,3};
        int k = 2;
        int[] ans = o.maxSubsequence(nums, k);
        System.out.println(Arrays.toString(ans));
    }
}
