public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        // if n is negative, get the first 1, then change n to positive
        // just flip the first bit
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

    public int hammingWeight1(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) count++;
            n = n >>> 1;
        }
        return count;
    }
}
