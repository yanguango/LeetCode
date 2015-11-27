public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0
                || matrix[0].length == 0)
            return 0;

        int[][] histograms = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    histograms[i][j] = 0;
                } else {
                    histograms[i][j] = i == 0 ? 1 : histograms[i - 1][j] + 1;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < histograms.length; i++) {
            max = Math.max(max, largestRectangleArea(histograms[i]));
        }
        return max;
    }

    public int largestRectangleArea(int[] height) {
        if (height.length == 0) return 0;
        int max = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < height.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
                max = Math.max(max, height[i]);
            } else {
                while (!stack.isEmpty() && height[stack.peek()] > height[i]) {
                    int hi = stack.pop();
                    int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                    max = Math.max(width  * height[hi], max);
                }
                stack.push(i);
            }
        }

        while (!stack.isEmpty()) {
            int hi = stack.pop();
            int width = stack.isEmpty() ? height.length : height.length - stack.peek() - 1;
            max = Math.max(width  * height[hi], max);
        }
        return max;
    }
}