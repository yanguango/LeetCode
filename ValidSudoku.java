public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!isValidArea(board, i, i, 0, 8)) return false;
            if (!isValidArea(board, 0, 8, i, i)) return false;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!isValidArea(board, i * 3, i * 3 + 2 , j * 3, j * 3 + 2)) return false;
                if (!isValidArea(board, j * 3, j * 3 + 2 , i * 3, i * 3 + 2)) return false;
            }
        }
        return true;
    }

    public boolean isValidArea(char[][] board, int top, int bottom, int left, int right) {
        boolean[] used = new boolean[10];
        for (int i = top; i <= bottom; i++) {
            for (int j = left; j <= right; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (used[c - '0']) return false;
                    else used[c - '0'] = true;
                }
            }
        }
        return true;
    }
}
