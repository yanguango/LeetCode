public class Solution {
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                updateCell(board, i, j);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] > 1)
                    board[i][j] = (board[i][j] + 1) % 2;
            }
        }
    }

    public void updateCell(int[][] board, int row, int col) {
        int[][] directions = {{ -1, -1}, { -1, 0}, { -1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        int live = 0;
        for (int d = 0; d < directions.length; d++) {
            int i = row + directions[d][0];
            int j = col + directions[d][1];
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) continue;
            if (board[i][j] % 2 == 1) live++;
        }

        if (board[row][col] == 1 && (live < 2 || live > 3)) {
            board[row][col] = 3;
        } else if (board[row][col] == 0 && live == 3) {
            board[row][col] = 2;
        }
    }
}
