package POTD_LEETCODE;
import java.util.*;

public class SnapShotArray {

    List<Map<Integer, Integer>> list;

    public SnapShotArray(int length) {
        this.list = new ArrayList<>();
        list.add(new HashMap<>());
    }

    public void set(int index, int val) {
        int snapId = list.size() - 1;
        list.get(snapId).put(index, val);
    }

    public int snap() {
        list.add(new HashMap<>());
        return list.size() - 2;
    }

    public int get(int index, int snap_id) {
        for (int i = snap_id; i >= 0; i--) {
            if (list.get(i).containsKey(index)) {
                return list.get(i).get(index);
            }
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
