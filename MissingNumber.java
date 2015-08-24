public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        long expectedSum = n * (n + 1) / 2;
        long sum = 0;
        for (int num : nums) sum += num;
        return (int)(expectedSum - sum);
    }
}
