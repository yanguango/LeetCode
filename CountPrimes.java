import java.util.*;

public class CountPrimes {
    public int countPrimes(int n) {
        BitSet bs = new BitSet(n);
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!bs.get(i)) {
                count++;
                int notPrime = i * 2;
                while (notPrime < n) {
                    bs.set(notPrime);
                    notPrime += i;
                }
            }
        }
        return count;
    }
}
