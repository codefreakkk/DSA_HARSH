package POTD_LEETCODE;
import java.util.*;

public class GroupThePeopleGivenByGroupSize {

    class Pair {
        int index, value;
        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int n = groupSizes.length;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.value - b.value);
        for (int i = 0; i < n; i++) {
            pq.offer(new Pair(i, groupSizes[i]));
        }

        List<List<Integer>> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            Pair pair = pq.peek();
            int value = pair.value;

            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < value; j++) {
                if (pq.peek().value != value) {
                    break;
                }
                list.add(pq.poll().index);
            }
            ans.add(list);
        }
        return ans;
    }


    public static void main(String[] args) {

    }
}
