public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) return 0;
        int start = 0, end = -1;
        int sum = 0;
        int res = 0;
        while (end < nums.length) {
            if (sum >= s) {
                int length = end - start + 1;
                res = res == 0 ?  length : Math.min(res, length);
                sum -= nums[start++];
            } else {
                end++;
                if (end > nums.length - 1) break;
                sum += nums[end];
            }
        }
        return res;
    }
}
