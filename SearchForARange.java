import java.util.*;

public class SearchForARange {
    public int[] searchRange(int[] nums, int target) {
        int range_start = -1, range_end = -1;
        int[] res = new int[2];
        res[0] = searchRangeStart(nums, target, 0, nums.length - 1);
        res[1] = searchRangeEnd(nums, target, 0, nums.length - 1);
        return res;
    }

    public int searchRangeStart(int[] nums, int target, int start, int end) {
        if (start > end) return -1;
        int mid = start + (end - start) / 2;
        if (nums[mid] < target)
            return searchRangeStart(nums, target, mid + 1, end);
        else if (nums[mid] > target)
            return searchRangeStart(nums, target, start, mid - 1);
        else {
            if (mid == 0 || nums[mid - 1] != target) return mid;
            else return searchRangeStart(nums, target, start, mid - 1);
        }
    }

    public int searchRangeEnd(int[] nums, int target, int start, int end) {
        if (start > end) return -1;
        int mid = start + (end - start) / 2;
        if (nums[mid] < target)
            return searchRangeEnd(nums, target, mid + 1, end);
        else if (nums[mid] > target)
            return searchRangeEnd(nums, target, start, mid - 1);
        else {
            if (mid == nums.length - 1 || nums[mid + 1] != target) return mid;
            else return searchRangeEnd(nums, target, mid + 1, end);
        }
    }
}
