package Graph;

import java.util.*;

public class ReachableNodesInSubdividedGraph {
    class Pair {
        int node, moves;
        public Pair(int node, int moves) {
            this.node = node;
            this.moves = moves;
        }
    }

    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        int m = edges[0].length;
        int[] visited = new int[n];

        int[][] edge = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                edge[i][j] = -1;
        }

        for (int[] uv : edges) {
            int u = uv[0];
            int v = uv[1];
            int w = uv[2];
            edge[u][v] = w;
            edge[v][u] = w;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.moves - a.moves);
        pq.offer(new Pair(0, maxMoves));

        int ans = 0;
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int node = pair.node;
            ans++;

            for (int i = 0; i < m; i++) {
                if (edge[node][i] == -1) {
                    if (visited[i] == 0 && maxMoves >= edge[node][i] + 1)
                    {
                        pq.offer(new Pair(i, maxMoves - edge[node][i] - 1));
                    }
                    int movesLeft = Math.min(maxMoves, edge[node][i] + 1);
                    ans += movesLeft;

                    edge[node][i] -= movesLeft;
                    edge[i][node] -= movesLeft;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
