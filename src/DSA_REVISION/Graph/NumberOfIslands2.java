package DSA_REVISION.Graph;

import java.util.*;

public class NumberOfIslands2 {

    private boolean isValid(int row, int col, int n, int m, int[][] visited) {
        return row < 0 || row >= n || col < 0 || col >= m;
    }

    public List<Integer> numberOfIslands(int n, int m, int[][] operators) {
        DisjointSet ds = new DisjointSet(n * m);

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int[][] visited = new int[n][m];
        int count = 0;

        List<Integer> ans = new ArrayList<>();

        for (int[] edge : operators) {
            int row = edge[0];
            int col = edge[1];

            if (visited[row][col] == 1) {
                continue;
            }
            visited[row][col] = 1;
            count++;

            for (int i = 0; i < 4; i++) {
                int numRow = row + dx[i];
                int numCol = col + dy[i];

                if (!isValid(numRow, numCol, n, m, visited)) {
                    if (visited[numRow][numCol] == 1) {
                        int node = row * m + col;
                        int adjacentNode = numRow * m + numCol;
                        if (ds.findParent(node) != ds.findParent(adjacentNode)) {
                            ds.unionBySize(node, adjacentNode);
                            count--;
                        }
                    }
                }
            }
            ans.add(count);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
