public class Sqrt {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        int low = 0;
        int hi = x;
        int mid = 0;
        while (low <= hi) {
            mid = low + (hi - low) / 2;
            long currentPow = (long)mid * mid;
            long nextPow = (long)(mid + 1) * (mid + 1);
            if (currentPow <= x && nextPow > x) break;
            if (currentPow < x) low = mid + 1;
            else hi = mid - 1;
        }
        return mid;
    }
}
