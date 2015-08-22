import java.util.Arrays;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, word, 0)) return true;
                else continue;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j,
                       String word, int index) {
        if (index > word.length() - 1) return true;
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1) return false;
        if (board[i][j] != word.charAt(index)) return false;
        char temp = board[i][j];
        board[i][j] = '$';
        boolean result = (dfs(board, i + 1, j, word, index + 1) ||
                          dfs(board, i - 1, j, word, index + 1) ||
                          dfs(board, i, j + 1, word, index + 1) ||
                          dfs(board, i, j - 1, word, index + 1));
        board[i][j] = temp;
        return result;

    }
}
