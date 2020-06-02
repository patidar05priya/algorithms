package dynamicEasy;

public class CountSquareSubmatrices {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        };

        System.out.println(countSquares(matrix));
    }

    static public int countSquares(int[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return 0;
        }
        int count = 0;
        int column = matrix[0].length;
        if (column == 1) {
            return matrix[0][0];
        }

        int[][] dp = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i == 0 || j == 0 || matrix[i][j] == 0) {
                    dp[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j - 1], dp[i - 1][j])) + 1;
                }
                count += dp[i][j];
            }
        }
        return count;

    }
}
