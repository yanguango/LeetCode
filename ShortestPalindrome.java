public class Solution {
    public String shortestPalindrome(String s) {
        int center = 0;
        int longgestPrefix = 0;
        while (center < s.length()) {
            int centerEnd = center;
            while (centerEnd + 1 < s.length() && s.charAt(centerEnd + 1) == s.charAt(centerEnd))
                centerEnd++;

            int i = center;
            int j = centerEnd;
            center = centerEnd + 1;

            while (i - 1 >= 0 && j + 1 < s.length() && s.charAt(i - 1) == s.charAt(j + 1)) {
                i--;
                j++;
            }

            if (i == 0) {
                longgestPrefix = Math.max(longgestPrefix, j - i + 1);
                continue;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(longgestPrefix));
        sb.reverse();
        sb.append(s);
        return sb.toString();
    }
}
