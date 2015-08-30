import java.util.*;

public class SpiralMatrix2 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int top_border = 0;
        int right_border = n - 1;
        int bottom_border = n - 1;
        int left_border = 0;
        int num = 1;
        while (top_border <= bottom_border && left_border <= right_border) {
            if (left_border > right_border) return matrix;
            for (int i = left_border; i <= right_border; i++) {
                matrix[top_border][i] = num++;
            }
            top_border++;

            if (top_border > bottom_border) return matrix;
            for (int i = top_border; i <= bottom_border; i++) {
                matrix[i][right_border] = num++;
            }
            right_border--;

            if (left_border > right_border) return matrix;
            for (int i = right_border; i >= left_border; i--) {
                matrix[bottom_border][i] = num++;
            }
            bottom_border--;

            if (top_border > bottom_border) return matrix;
            for (int i = bottom_border; i >= top_border; i--) {
                matrix[i][left_border] = num++;
            }
            left_border++;
        }
        return matrix;
    }
}
