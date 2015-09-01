public class TrappingRainWater {
    public int trap(int[] height) {
        if (height.length < 3) return 0;
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];

        maxLeft[1] = height[0];
        for (int i = 2; i < height.length; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        }

        maxRight[height.length - 2] = height[height.length - 1];
        for (int i = height.length - 3; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }

        int res = 0;
        for (int i = 1; i < height.length - 1; i++) {
            res += Math.max(Math.min(maxLeft[i], maxRight[i]) - height[i], 0);
        }
        return res;
    }
}
