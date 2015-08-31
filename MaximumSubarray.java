public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int start = 0, end = -1;
        int res = Integer.MIN_VALUE;
        int sum = 0;
        while (end < nums.length) {
            if (sum < 0) {
                sum = 0;
                start = end + 1;
            } else {
                end++;
                if (end > nums.length - 1) break;
                sum += nums[end];
                res = Math.max(res, sum);
            }
        }
        return res;
    }

    // dp
    public int maxSubArray1(int[] nums) {
        int max_local = nums[0];
        int max_global = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max_local = Math.max(max_local + nums[i], nums[i]);
            max_global = Math.max(max_global, max_local);
        }
        return max_global;
    }
}
