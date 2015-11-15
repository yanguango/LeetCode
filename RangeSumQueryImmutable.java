public class NumArray {
    int[] prefixSum;

    public NumArray(int[] nums) {
        prefixSum = nums;
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + prefixSum[i];
        }
    }

    public int sumRange(int i, int j) {
        return prefixSum[j] - (i == 0 ? 0 : prefixSum[i - 1]);
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);