public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            while(num <= nums.length && num > 0 && num != nums[num - 1]) {
                int temp = nums[num - 1];
                nums[num - 1] = num;
                num = temp;
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) return i + 1;
        }
        return nums.length + 1;
    }
}