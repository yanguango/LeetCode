import java.util.Arrays;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        boolean[][] used = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                for (boolean[] row : used) Arrays.fill(row, false);
                if (search(board, i, j, used, word, 0)) return true;
                else continue;
            }
        }
        return false;
    }

    public boolean search(char[][] board, int i, int j,
                          boolean[][] used, String word, int index) {
        if (index > word.length() - 1) return true;
        if (i < 0 || i > board.length - 1) return false;
        if (j < 0 || j > board[0].length - 1) return false;
        if (used[i][j] || board[i][j] != word.charAt(index)) return false;
        used[i][j] = true;
        boolean result = (search(board, i + 1, j, used, word, index + 1) ||
                          search(board, i - 1, j, used, word, index + 1) ||
                          search(board, i, j + 1, used, word, index + 1) ||
                          search(board, i, j - 1, used, word, index + 1));
        used[i][j] = false;
        return result;

    }
}
