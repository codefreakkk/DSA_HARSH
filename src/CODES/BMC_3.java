package CODES;

public class BMC_3 {
    public static void main(String[] args) {
        int n = 25; // Change this to the desired square size
        int[][] square = createSquare(n);

        printSquare(square);

        int diagonalSum = calculateDiagonalSum(square);
        System.out.println("The sum of the numbers on the diagonals is: " + diagonalSum);
    }

    // Function to create a square and fill it with numbers
    public static int[][] createSquare(int n) {
        int[][] square = new int[n][n];
        int num = 1;
        int left = 0, right = n - 1, top = 0, bottom = n - 1;

        while (num <= n * n) {
            for (int i = top; i <= bottom; i++) {
                square[i][left] = num++;
            }
            left++;

            for (int i = left; i <= right; i++) {
                square[top][i] = num++;
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                square[i][right] = num++;
            }
            right--;

            for (int i = left; i <= right; i++) {
                square[bottom][i] = num++;
            }
            bottom--;
        }

        return square;
    }

    // Function to calculate the sum of the diagonal elements
    public static int calculateDiagonalSum(int[][] square) {
        int sum = 0;
        int n = square.length;

        for (int i = 0; i < n; i++) {
            sum += square[i][i];          // Top-left to bottom-right diagonal
            sum += square[i][n - i - 1];  // Top-right to bottom-left diagonal
        }

        // Subtract the center element as it was added twice
        sum -= square[n / 2][n / 2];

        return sum;
    }

    // Function to print the square
    public static void printSquare(int[][] square) {
        for (int[] row : square) {
            for (int num : row) {
//                System.out.printf(num);
            }
            System.out.println();
        }
    }
}