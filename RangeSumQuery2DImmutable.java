public class NumMatrix {
    private int[][] prefixSumMatrix;

    public NumMatrix(int[][] matrix) {
        prefixSumMatrix = matrix;
        for (int i = 0; i < prefixSumMatrix.length; i++) {
            for (int j = 1; j < prefixSumMatrix[0].length; j++) {
                prefixSumMatrix[i][j] = prefixSumMatrix[i][j - 1] + prefixSumMatrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
        for (int i = row1; i <= row2; i++) {
            res += prefixSumMatrix[i][col2] - (col1 == 0 ? 0 : prefixSumMatrix[i][col1 - 1]);
        }
        return res;
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);