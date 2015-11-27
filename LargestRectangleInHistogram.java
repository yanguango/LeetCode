public class Solution {
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