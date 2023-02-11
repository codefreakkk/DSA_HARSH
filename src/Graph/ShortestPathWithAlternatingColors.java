package Graph;
import java.util.*;
public class ShortestPathWithAlternatingColors {
    class Tupple {
        int node, color, distance;
        public Tupple(int node, int color, int distance) {
            this.node = node;
            this.color = color;
            this.distance = distance;
        }
    }
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<List<Tupple>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adjList.add(new ArrayList<>());

        for (int[] edge : redEdges) {
            if (edge.length == 0) break;
            adjList.get(edge[0]).add(new Tupple(edge[1], 1, 1));
        }
        for (int[] edge : blueEdges) {
            if (edge.length == 0) break;
            adjList.get(edge[0]).add(new Tupple(edge[1], 0, 1));
        }

        int[][] visited = new int[2][n];
        visited[0][0] = 1;
        visited[1][0] = 1;
        Queue<Tupple> queue = new LinkedList<>();

        for (Tupple tupple : adjList.get(0)) {
            queue.offer(new Tupple(tupple.node, tupple.color, 1));
            if (tupple.color == 1) {
                visited[1][tupple.node] = 1;
            }
            else visited[0][tupple.node] = 1;
        }

        int[] result = new int[n];
        Arrays.fill(result, (int) 1e9);
        result[0] = 0;

        while (!queue.isEmpty()) {
            Tupple tupple = queue.poll();
            int node = tupple.node;
            int color = tupple.color;
            int distance = tupple.distance;
            result[node] = Math.min(distance, result[node]);

            for (Tupple it : adjList.get(node)) {
                int currentNode = it.node;
                int currentColor = it.color;
                int currentDistance = it.distance;

                if (color == 1 && currentColor == 0 && visited[0][currentNode] == 0) {
                    visited[0][currentNode] = 1;
                    queue.offer(new Tupple(currentNode, currentColor, distance + currentDistance));
                }
                else if (color == 0 && currentColor == 1 && visited[1][currentNode] == 0) {
                    visited[1][currentNode] = 1;
                    queue.offer(new Tupple(currentNode, currentColor, distance + currentDistance));
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (result[i] == (int) 1e9)
                result[i] = -1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] r = {{0, 1}};
        int[][] b = {{1, 2}};
        ShortestPathWithAlternatingColors o = new ShortestPathWithAlternatingColors();
        System.out.println(Arrays.toString(o.shortestAlternatingPaths(3, r, b)));
    }
}
