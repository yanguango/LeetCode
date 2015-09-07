public class Pow {
    public double myPow(double x, int n) {
        return n < 0 ?  1 / pow(x, n) : pow(x, n);
    }

    public double pow(double x, int n) {
        if (n == 0) return 1.0;
        double powHalf = pow(x, n / 2);
        if (n % 2 == 0) return powHalf * powHalf;
        else return powHalf * powHalf * x;
    }
}
