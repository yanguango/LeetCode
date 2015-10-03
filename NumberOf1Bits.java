public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        if (n < 0) {
            count++;
            n = Integer.MAX_VALUE + n + 1;
        }
        while (n > 0) {
            if ((n & 1) == 1) count++;
            n = n >> 1;
        }
        return count;
    }
}
