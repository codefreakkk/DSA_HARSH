package leetcodeContest.Biweekly159;

import java.util.*;

public class ProblemA {
    /*
    1. find number of odd and even element
    2. check if swap is possible
    3. add even or odd element in queue (with original index) based on
       higher frequency of them, similarly store lowest frequency element in list
    4. traverse list and add elements from queue
    5. compute ans
     */

    class Pair {
        int element, index;
        public Pair (int element, int index) {
            this.element = element;
            this.index = index;
        }
    }

    public void storeElementsForEvenInQueue(List<Integer> list, Queue<Pair> queue, int[] nums, Map<Integer, Integer> map) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                queue.offer(new Pair(nums[i], i));
            } else {
                list.add(nums[i]);
            }
            map.put(nums[i], i);
        }
    }

    public void storeElementsForOddInQueue(List<Integer> list, Queue<Pair> queue, int[] nums, Map<Integer, Integer> map) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                queue.offer(new Pair(nums[i], i));
            } else {
                list.add(nums[i]);
            }
            map.put(nums[i], i);
        }
    }

    public int computeAnswer(List<Integer> list, Map<Integer, Integer> map, boolean isEven) {
        int ans = 0;
        for (int i = 0; i < list.size(); i++) {
            if (isEven && list.get(i) % 2 == 0) {
                ans += Math.abs(i - map.get(list.get(i)));
            }
            if (!isEven && list.get(i) % 2 == 0) {
                ans += Math.abs(i - map.get(list.get(i)));
            }
        }
        return ans;
    }

    public int minSwaps(int[] nums) {
        int n = nums.length, even = 0, odd = 0;

        for (int it : nums) {
            if (it % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        if (Math.abs(even - odd) > 1) {
            return -1;
        }

        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        if (even > odd) {
            storeElementsForEvenInQueue(list, queue, nums, map);
        } else if (odd > even) {
            storeElementsForOddInQueue(list, queue, nums, map);
        } else if (odd == even) {
            if (nums[0] % 2 == 0) {
                storeElementsForEvenInQueue(list, queue, nums, map);
            } else {
                storeElementsForOddInQueue(list, queue, nums, map);
            }
        }

        for (int i = 0; i <= list.size(); i += 2) {
            if (!queue.isEmpty()) {
                list.add(i, queue.poll().element);
            }
        }

        System.out.println(queue);
        System.out.println(map);
        System.out.println(list);


        if (odd > even) {
            return computeAnswer(list, map, false);
        } else if (even > odd) {
            return computeAnswer(list, map, true);
        } else if (odd == even) {
            if (nums[0] % 2 == 0) {
                return computeAnswer(list, map, true);
            } else {
                return computeAnswer(list, map, false);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ProblemA o = new ProblemA();
        System.out.println(o.minSwaps(new int[] {4,5,6,8}));
    }
}
