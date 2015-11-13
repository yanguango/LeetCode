public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        for (int n1 = 0; n1 <= nums.length - 3; n1++) {
            int n2 = n1 + 1;
            int n3 = nums.length - 1;
            while (n2 < n3) {
                if (nums[n1] + nums[n2] + nums[n3] < target) {
                    res += n3 - n2;
                    n2++;
                } else {
                    n3--;
                }
            }
        }
        return res;
    }
}