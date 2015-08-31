public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0;
        int end = m * n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int[] xy = coords(mid, m, n);
            int x = xy[0];
            int y = xy[1];
            if (matrix[x][y] < target) {
                start = mid + 1;
            } else if (matrix[x][y] > target) {
                end = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public int[] coords(int index, int m, int n) {
        int[] xy = new int[2];
        xy[0] = index / n;
        xy[1] = index % n;
        return xy;
    }
}
