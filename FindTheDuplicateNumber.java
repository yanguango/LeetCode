public class Solution {
    public int findDuplicate(int[] nums) {
        int lower = 1;
        int upper = nums.length - 1;
        int mid = 0;
        while (lower <= upper) {
            mid = lower + (upper - lower) / 2;
            int eqCount = 0, gtCount = 0, ltCount = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == mid) eqCount++;
                else if (nums[i] >= lower && nums[i] < mid) ltCount++;
                else if (nums[i] > mid && nums[i] <= upper) gtCount++;

                if (eqCount > 1) return mid;
            }
            if (gtCount > ltCount) lower = mid + 1;
            else upper = mid - 1;
        }
        return mid;
    }
}
