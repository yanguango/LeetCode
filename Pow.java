public class Pow {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (x == 0) return 0;
        if (x == 1) return 1;
        if (x == -1) return n % 2 == 0 ? 1 : -1;

        boolean neg = n < 0;
        double res = pow(x, n);
        return neg ?  1 / res : res;
    }

    public double pow(double x, int n) {
        if (n == 0) return 1.0;
        double powHalf = pow(x, n / 2);
        if (n % 2 == 0) return powHalf * powHalf;
        else return powHalf * powHalf * x;
    }
}
