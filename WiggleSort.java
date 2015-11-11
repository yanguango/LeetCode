public class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length < 2) return;
        for (int i = 1; i < nums.length; i++) {
            if ((i % 2 == 1) != (nums[i] > nums[i - 1])) {
                int temp = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = temp;
            }
        }
    }
}