public class UglyNumber {
    public boolean isUgly(int num) {
        if (num <= 0) return false;
        if (num == 1) return true;
        if (num == 2 || num == 3 || num == 5) {
            return true;
        } else {
            return (num % 2 == 0 ? isUgly(num / 2) : false) ||
                   (num % 3 == 0 ? isUgly(num / 3) : false) ||
                   (num % 5 == 0 ? isUgly(num / 5) : false);
        }
    }
}
