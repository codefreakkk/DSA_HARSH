package POTD_LEETCODE;
import java.util.*;

public class ShortestPathToGetAllKeys {

    class Tupple {
        int row, col, keys;
        public Tupple(int keys, int row, int col) {
            this.keys = keys;
            this.row = row;
            this.col = col;
        }
    }

    public int shortestPathAllKeys(String[] grid) {
        int n = grid.length;
        int m = grid[0].length();
        int startRow = 0, startCol = 0, keys = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = grid[i].charAt(j);
                if (c == '@') {
                    startRow = i;
                    startCol = j;
                }
                if (c >= 'a' && c <= 'f') {
                    keys++;
                }
            }
        }

        Set<String> set = new HashSet<>();
        set.add(0 + " " + startRow + " " + startCol);

        Queue<Tupple> queue = new LinkedList<>();
        queue.offer(new Tupple(0, startRow, startCol));

        int[] delCol = {-1, 0, 1, 0};
        int[] delRow = {0, 1, 0, -1};


        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                Tupple tupple = queue.poll();
                int row = tupple.row;
                int col = tupple.col;

                if (tupple.keys == (1 << keys) - 1) {
                    return steps;
                }
                for (int i = 0; i < 4; i++) {
                    int newRow = row + delRow[i];
                    int newCol = col + delCol[i];
                    int k = tupple.keys;
                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) {

                        char ch = grid[newRow].charAt(newCol);

                        if (ch == '#') continue;

                        if (ch >= 'a' && ch <= 'f') {
                            k |= 1 << (ch - 'a');
                        }

                        if (ch >= 'A' && ch <= 'F' && ((k >> (ch - 'A')) & 1) == 0) {
                            continue;
                        }

                        String visited = k + " " + newRow + " " + newCol;
                        if (!set.contains(visited)) {
                            queue.offer(new Tupple(k, newRow, newCol));
                            set.add(visited);
                        }
                    }

                }
            }
            steps++;
        }
        return -1;
    }

    public static void main(String[] args) {
        ShortestPathToGetAllKeys o = new ShortestPathToGetAllKeys();
        String[] s = {"@Aa"};
        System.out.println(o.shortestPathAllKeys(s));
    }
}
