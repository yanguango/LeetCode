public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int min_local = nums[0];
        int max_local = nums[0];
        int max_global = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp_min_local = min_local;
            min_local = Math.min(nums[i], Math.min(max_local * nums[i], min_local * nums[i]));
            max_local = Math.max(nums[i], Math.max(max_local * nums[i], temp_min_local * nums[i]));
            max_global = Math.max(max_global, max_local);
        }
        return max_global;
    }
}
