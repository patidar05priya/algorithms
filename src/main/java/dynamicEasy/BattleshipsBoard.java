package dynamicEasy;

public class BattleshipsBoard {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'X', '.', '.', 'X'},
                {'.', '.', '.', 'X'},
                {'.', '.', '.', 'X'}
        };

        System.out.println(countBattleships(board));

    }

    static public int countBattleships(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        if (col == 0) {
            return 0;
        }
        int count = 0;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'X' && !visited[i][j]) {
                    dfs(board, i, j, visited, row, col);
                    count++;
                }

            }
        }

        return count;

    }


    static public void dfs(char[][] board, int i, int j, boolean[][] visited, int row, int col) {

        int[] rows = new int[]{0, 1};
        int[] cols = new int[]{1, 0};
        visited[i][j] = true;
        for (int l = 0; l < rows.length; l++) {
            if (isvalid(board, i + rows[l], j + cols[l], visited, row, col)) {
                dfs(board, i + rows[l], j + cols[l], visited, row, col);
            }
        }


    }

    static boolean isvalid(char[][] board, int i, int j, boolean[][] visited, int row, int col) {
        return (i >= 0 && j >= 0 && i < row && j < col && board[i][j] == 'X' && !visited[i][j]);
    }
}
