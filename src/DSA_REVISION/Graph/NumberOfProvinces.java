package DSA_REVISION.Graph;

// solution using disjoint set
public class NumberOfProvinces {

    public int findCircleNum(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        DisjointSet ds = new DisjointSet(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    ds.unionBySize(i, j);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i == ds.findParent(i)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
