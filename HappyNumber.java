import java.util.*;

public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int next = nextNum(n);
        while (!set.contains(next)) {
            if (next == 1) return true;
            set.add(next);
            next = nextNum(next);
        }
        return false;
    }

    public int nextNum(int n) {
        int num = 0;
        while (n > 0) {
            int last = n % 10;
            num += last * last;
            n = n / 10;
        }
        return num;
    }
}
