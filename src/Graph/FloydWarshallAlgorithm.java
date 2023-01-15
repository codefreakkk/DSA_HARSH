package Graph;

public class FloydWarshallAlgorithm {
    public void shortestDistance(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == -1)
                    matrix[i][j] = (int) 1e9;
            }
        }

        // floyd warshall algoithm
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == (int) 1e9)
                    matrix[i][j] = -1;
            }
        }

//        ****if you want to detect negative cycle in graph****
//        for (int i = 0; i < n; i++) {
//            if (matrix[i][i] < 0) {
//                // negative cycle found
//            }
//        }
    }

    public static void main(String[] args) {

    }
}
