public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int res = 0;
        while (start < end) {
            int shorter = Math.min(height[start], height[end]);
            res = Math.max(res, (end - start) * shorter);
            if (height[start] >= height[end]) end--;
            else start++;
        }
        return res;
    }
}
