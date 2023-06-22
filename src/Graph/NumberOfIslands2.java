package Graph;

import java.util.*;

public class NumberOfIslands2 {
    class DisjointSet {
        List<Integer> parent, size;
        public DisjointSet(int v) {
            this.parent = new ArrayList<>();
            this.size = new ArrayList<>();
            for (int i = 0; i <= v; i++) {
                parent.add(i);
                size.add(1);
            }
        }

        public int findParent(int node) {
            if (node == parent.get(node))
                return node;

            int parentNode = findParent(parent.get(node));
            parent.set(node, parentNode);
            return parentNode;
        }

        public void unionBySize(int u, int v) {
            int parent_u = findParent(u);
            int parent_v = findParent(v);
            if (parent_u == parent_v)
                return;

            if (size.get(parent_v) < size.get(parent_u)) {
                parent.set(parent_v, parent_u);
                size.set(parent_u, size.get(parent_u) + size.get(parent_v));
            }
            else {
                parent.set(parent_u, parent_v);
                size.set(parent_v, size.get(parent_u) + size.get(parent_v));
            }
        }
    }

    public boolean isValid(int row, int col, int n, int m, int[][] visited) {
        return (row >= 0 && row < m) && (col >= 0 && col < m) && visited[row][col] == 1;
    }

    public List<Integer> numsOfIslands(int rows, int cols, int[][] grid) {
        int[][] visited = new int[rows][cols];
        int count = 0, n = grid.length, m = grid[0].length;
        DisjointSet ds = new DisjointSet(rows * cols);

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        List<Integer> ans = new ArrayList<>();
        for (int[] edge : grid) {
            int u = edge[0];
            int v = edge[1];

            if (visited[u][v] == 1)
                continue;

            visited[u][v] = 1;
            count++;
            for (int i = 0; i < 4; i++) {
                int row = u + delRow[i];
                int col = v + delCol[i];

                int updatedPosition = row * m + col;
                int currentPosition = u * m + v;
                if (isValid(row, col, n, m, visited)) {
                    if (ds.findParent(updatedPosition) != ds.findParent(currentPosition)) {
                        count--;
                        ds.unionBySize(updatedPosition, currentPosition);
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
