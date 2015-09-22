public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] rotated = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[i][n - 1 - j] = matrix[j][i];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = rotated[i][j];
            }
        }
    }
}

// in place solution
public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n - 1 - i; j++)
                swap(matrix, i, j, n - 1 - j, n - 1 - i);

        for (int i = 0; i < n / 2; i++)
            for (int j = 0; j < n; j++)
                swap(matrix, i, j, n - 1 - i, j);
    }

    public void swap(int[][] matrix, int i1, int j1, int i2, int j2) {
        int tmp = matrix[i1][j1];
        matrix[i1][j1] = matrix[i2][j2];
        matrix[i2][j2] = tmp;
    }
}
