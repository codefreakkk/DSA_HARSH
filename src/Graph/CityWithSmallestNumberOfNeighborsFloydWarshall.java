package Graph;

public class CityWithSmallestNumberOfNeighborsFloydWarshall {
    public int findCity(int n, int m, int[][] edges, int distanceThreshold) {
        int[][] distance = new int[n][n];
        int max = (int) 1e9;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                distance[i][j] = max;
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            distance[u][v] = weight;
            distance[v][u] = weight;
        }

        for (int i = 0; i < n; i++)
            distance[i][i] = 0;

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distance[i][k] == max || distance[k][j] == max)
                        continue;

                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }

        int city = -1, cityCount = n + 1;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (distance[i][j] <= distanceThreshold)
                    count++;
            }
            if (count <= cityCount) {
                city = i;
                cityCount = count;
            }
        }
        return city;
    }

    public static void main(String[] args) {

    }
}
