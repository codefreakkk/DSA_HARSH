package Graph;

import java.util.*;
public class SnakesAndLadders {
    class Pair {
        int row, col;
        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int m = board[0].length;

        HashMap<Integer, Pair> map = new HashMap<>();
        int index = 1;

        boolean leftToRight = true;
        for (int i = n - 1; i >= 0; i--) {
            if (leftToRight) {
                for (int j = 0; j < m; j++)
                    map.put(index++, new Pair(i, j));
            }
            else {
                for (int j = m - 1; j >= 0; j--)
                    map.put(index++, new Pair(i, j));
            }
            leftToRight = !leftToRight;
        }

        int[] distance = new int[n * n + 1];
        Arrays.fill(distance, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        distance[1] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next = current + 1; next <= Math.min(current + 6, n * n); next++) {
                Pair pair = map.get(next);
                int row = pair.row;
                int col = pair.col;
                int destination = board[row][col] == -1 ? next : board[row][col];

                if (distance[destination] == -1) {
                    distance[destination] = distance[current] + 1;
                    queue.offer(destination);
                }
            }
        }
        return distance[n * n];
    }

    public static void main(String[] args) {
        int[][] board = {
                {-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}
        };
        SnakesAndLadders o = new SnakesAndLadders();
        System.out.println(o.snakesAndLadders(board));
    }
}
