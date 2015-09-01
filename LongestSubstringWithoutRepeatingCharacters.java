public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        boolean[] map = new boolean[256];
        int res = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (map[current]) {
                while (s.charAt(start) != current) {
                    map[s.charAt(start++)] = false;
                }
                start++;
            } else {
                map[current] = true;
            }
            res = Math.max(res, i - start + 1);
        }
        return res;
    }
}
