public class Solution {
    public int findPeakElement(int[] nums) {
        long prev = (long)Integer.MIN_VALUE - 1;
        long next;
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) next = (long)Integer.MIN_VALUE - 1;
            else next = nums[i + 1];
            if (nums[i] > prev && nums[i] > next) return i;
            prev = nums[i];
        }
        return -1;
    }
}
