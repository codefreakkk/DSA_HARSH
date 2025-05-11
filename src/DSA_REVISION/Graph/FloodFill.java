package DSA_REVISION.Graph;

public class FloodFill {

    private boolean valid(int[][] image, int row, int col, int color, int newColor) {
        int n = image.length, m = image[0].length;
        return row >= 0 && row < n && col >= 0 && col < m && image[row][col] == color && image[row][col] != newColor;
    }

    public void dfs(int[][] image, int sr, int sc, int color, int newColor) {
        image[sr][sc] = newColor;

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, -1, 0, 1};

        for (int i = 0; i < 4; i++) {
            int numRow = sr + delRow[i];
            int numCol = sc + delCol[i];

            if (valid(image, numRow, numCol, color, newColor)) {
                dfs(image, numRow, numCol, color, newColor);
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        dfs(image, sr, sc, image[sr][sc], color);
        return image;
    }
}
