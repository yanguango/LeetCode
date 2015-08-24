public class SortColors {
    public void sortColors(int[] nums) {
        int k = 0;
        int p = nums.length;
        int i = 0;
        while (i < p) {
            if (nums[i] == 0) {
                swap(nums, k++, i++);
            } else if (nums[i] == 2) {
                swap(nums, --p, i);
            } else {
                i++;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
