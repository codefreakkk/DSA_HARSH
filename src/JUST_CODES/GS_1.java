package JUST_CODES;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class GS_1 {

    class UnionFind {
        private int cnt = 0;
        private int[] parent, rank;

        public UnionFind(int n) {
            cnt = n;
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }


        public int Find(int x) {
            if (x != parent[x]) {
                parent[x] = Find(parent[x]);
            }
            return parent[x];
        }

        public void Union(int x, int y) {
            int rootX = Find(x);
            int rootY = Find(y);
            if (rootX == rootY) return;
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            }
            else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            }
            else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            cnt--;
        }

        public int cnt() {
            return cnt;
        }
    }

    public int findCircleNum(int[][] M) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < M.length; i++)
            adjList.add(new ArrayList<>());

        for (int[] edge : M) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        int n = 9;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
           if (uf.Find(M[0][0]) != uf.Find(M[0][1]))
               uf.Union(M[0][0], M[0][1]);
        }
        return uf.cnt();
    }
    public static void main(String[] args) {
        int[][] edge = {
                {0, 1},{1,3},{1,6},{2,3},{2,4},{3,1},{4,7},{5,0},{5,1},{6,5},{7,2},{7,3},{7,8},{8,3}
        };
        int n = 9;
        GS_1 o = new GS_1();
        System.out.println(o.findCircleNum(edge));
    }

}
