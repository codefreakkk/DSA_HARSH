package REVISION.GraphAlgos;

public class FloydWarshall {
    public void shortest_distance(int[][] matrix) {
        int n = matrix.length;
        int max = (int) 1e9;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1)
                    matrix[i][j] = max;
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == max)
                    matrix[i][j] = -1;
            }
        }
    }

    public static void main(String[] args) {

    }
}
