public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int insert = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[insert];
                nums[insert++] = nums[i];
                nums[i] = tmp;
            }
        }
    }
}
