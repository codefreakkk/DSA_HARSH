package recursion.backtracking;

import java.util.*;

public class SudokuStriver {
    public static boolean isSafeToMove(char[][] board, int row, int col, char value) {
        for(int i = 0; i < 9; i++) {
            if(board[row][i] == value) return false;
            if(board[i][col] == value) return false;
            if(board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == value) return false;
        }
        return true;
    }

    public static boolean solve(char[][] board) {
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board.length; col++) {
                if(board[row][col] == '.') {
                    for(char ch = '1'; ch <= '9'; ch++) {
                        if(isSafeToMove(board, row, col, ch)) {
                            board[row][col] = ch;
                            boolean canSolveFurther = solve(board);
                            if(canSolveFurther) {
                                return true;
                            } else {
                                board[row][col] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    static void sudoku(char[][] board) {
        solve(board);
    }

    public static void main(String[] args) {

    }
}
