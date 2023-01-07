package Graph;

public class FloodFill {
    public boolean isValid(int[][] image, int row, int col, int color, int newColor) {
        int n = image.length, m = image[0].length;
        return (row >= 0 && row < n) && (col >= 0 && col < m) && (image[row][col] == color && image[row][col] != newColor);
    }

    public void dfs(int[][] image, int row, int col, int color, int newColor, int[] delRow, int[] delCol) {
        image[row][col] = newColor;
        for (int i = 0; i < 4; i++) {
            int newRow = row + delRow[i];
            int newCol = col + delCol[i];
            if (isValid(image, newRow, newCol, color, newColor))
                dfs(image, newRow, newCol, color, newColor, delRow, delCol);
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        dfs(image, sr, sc, color, newColor, delRow, delCol);
        return image;
    }

    public static void main(String[] args) {

    }
}
