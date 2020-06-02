package dynamicEasy;

import java.util.Arrays;

public class MatrixBlockSum {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] res = matrixBlockSum(matrix, 1);
        for(int i=0;i<res.length ;i++){
            System.out.println(Arrays.toString(res[i]));
        }

    }

    static public int[][] matrixBlockSum(int[][] mat, int K) {
        int row = mat.length;
        int col = mat[0].length;

        int[][] result = new int[row][col];
        int[][] dp = new int[row][col];
        dp[0][0] = mat[0][0];

        // fill dp for 0th column
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + mat[i][0];
        }

        // fill dp for 0th row
        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i - 1] + mat[0][i];
        }

        // fill remaining dp array
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + mat[i][j];
            }
        }

        // main logic, read dp array and replace
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                int startRow = Math.max(0, i - K);
                int startCol = Math.max(0, j - K);

                int endRow = Math.min(row - 1, i + K);
                int endCol = Math.min(col - 1, j + K);

                if (startRow == 0 && startCol == 0) {
                    result[i][j] = dp[endRow][endCol];
                } else if (startRow == 0) {
                    result[i][j] = dp[endRow][endCol] - dp[endRow][startCol - 1];
                } else if (startCol == 0) {
                    result[i][j] = dp[endRow][endCol]-dp[startRow-1][endCol];
                } else {
                    result[i][j] = dp[endRow][endCol] - dp[startRow - 1][endCol] - dp[endRow][startCol - 1] + dp[startRow - 1][startCol - 1];
                }
            }
        }

        return result;
    }
}
