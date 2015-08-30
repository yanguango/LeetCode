import java.util.*;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) return res;

        int top_border = 0;
        int right_border = matrix[0].length - 1;
        int bottom_border = matrix.length - 1;
        int left_border = 0;

        while (top_border <= bottom_border && left_border <= right_border) {
            if (left_border > right_border) return res;
            for (int i = left_border; i <= right_border; i++) {
                res.add(matrix[top_border][i]);
            }
            top_border++;

            if (top_border > bottom_border) return res;
            for (int i = top_border; i <= bottom_border; i++) {
                res.add(matrix[i][right_border]);
            }
            right_border--;

            if (left_border > right_border) return res;
            for (int i = right_border; i >= left_border; i--) {
                res.add(matrix[bottom_border][i]);
            }
            bottom_border--;

            if (top_border > bottom_border) return res;
            for (int i = bottom_border; i >= top_border; i--) {
                res.add(matrix[i][left_border]);
            }
            left_border++;

        }
        return res;
    }
}
