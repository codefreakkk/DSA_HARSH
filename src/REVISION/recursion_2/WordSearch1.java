package REVISION.recursion_2;

public class WordSearch1 {
    private boolean solve(int i, int j, int counter, char[][] board, String word) {
        int n = board.length, m = board[0].length;

        if (counter == word.length()) {
            return true;
        }
        if (i >= n || j >= m || i < 0 || j < 0 || board[i][j] != word.charAt(counter) || board[i][j] == '#') {
            return false;
        }
        char ch = board[i][j];
        board[i][j] = '#';
        counter += 1;

        boolean left = solve(i, j - 1, counter, board, word);
        boolean down = solve(i + 1, j, counter, board, word);
        boolean right = solve(i, j + 1, counter, board, word);
        boolean up = solve(i - 1, j, counter, board, word);

        board[i][j] = ch;
        return left || down || right || up;
    }

    public boolean exists(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (solve(i, j, 0, board, word)) {
                    return true;
                }
            }
        }
        return false;
    }

}
