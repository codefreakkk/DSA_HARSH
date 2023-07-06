package DynamicProgramming;
import java.util.*;

public class DeleteAndEarn {

    private int solve(int index, int prev, List<Integer> list, HashMap<Integer, Integer> map) {
        if (index >= list.size()) return 0;

        int pick = 0;
        if (prev == -1) {
            pick = list.get(index) * map.get(list.get(index)) + solve(index + 1, index, list, map);
        }
        else {
            if (list.get(prev) + 1 != list.get(index)) {
                pick = list.get(index) * map.get(list.get(index)) + solve(index + 1, index, list, map);
            }
        }
        int notPick = solve(index + 1, prev, list, map);

        return Math.max(pick, notPick);
    }

    public int deleteAndEarn(int[] nums) {
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> mp : map.entrySet()) {
            list.add(mp.getKey());
        }

        Collections.sort(list);
        return solve(0, -1, list, map);
    }


    public static void main(String[] args) {
        DeleteAndEarn o = new DeleteAndEarn();
        int[] nums = {1,2,3,15,16,17,18};
        System.out.println(o.deleteAndEarn(nums));
    }
}
