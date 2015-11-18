public class Solution {
    public boolean isAdditiveNumber(String num) {
        for (int i = 0; i < num.length() - 2; i++) {
            long n1 = Long.valueOf(num.substring(0, i + 1));
            if (num.charAt(i + 1) != '0') {
                for (int j = i + 1; j < num.length() - 1; j++) {
                    long n2 = Long.valueOf(num.substring(i + 1, j + 1));
                    if (dfs(num, j + 1, n1, n2)) return true;
                }
            } else {
                if (dfs(num, i + 2, n1, 0)) return true;
            }
        }
        return false;
    }

    public boolean dfs(String num, int start, long n1, long n2) {
        if (start >= num.length()) return false;
        if (num.charAt(start) == '0') {
            return dfs(num, start + 1, n2, 0);
        } else {
            long tail = Long.valueOf(num.substring(start));
            if (tail == (n1  + n2)) return true;

            for (int i = start; i < num.length(); i++) {
                long n3 = Long.valueOf(num.substring(start, i + 1));
                if (n3 == n1 + n2) {
                    return dfs(num, i + 1, n2, n3);
                } else if (n3 > n1 + n2) {
                    break;
                }
            }
            return false;
        }
    }
}