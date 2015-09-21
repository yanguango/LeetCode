public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int maxLen = 0;
        int start = 0, end = 0;
        int from = 0;
        while (from < s.length()) {
            int to = from;
            while (to + 1 < s.length() && s.charAt(to + 1) == s.charAt(from)) {
                to++;
            }
            int nextFrom = to + 1;
            while (from - 1 >= 0 && to + 1 < s.length() && s.charAt(from - 1) == s.charAt(to + 1)) {
                from--;
                to++;
            }
            if (to - from + 1 > maxLen) {
                maxLen = to - from + 1;
                start = from;
                end = to;
            }
            from = nextFrom;
        }
        return s.substring(start, end + 1);
    }

}
