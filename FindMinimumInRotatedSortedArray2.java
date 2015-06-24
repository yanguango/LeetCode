public class FindMinimumInRotatedSortedArray2 {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) start = mid + 1;
            else if (nums[mid] < nums[end]) end = mid;
            else end--;
        }
        return nums[end];
    }
}