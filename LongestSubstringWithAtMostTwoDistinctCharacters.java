public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null) return 0;
        if (s.length() < 2) return s.length();
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 1;
        int max = Integer.MIN_VALUE;
        map.put(s.charAt(0), 1);
        while (start < s.length() && end < s.length()) {
            while (end < s.length() && map.size() <= 2) {
                char c = s.charAt(end);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                    end++;
                } else if (map.size() < 2) {
                    map.put(c, 1);
                    end++;
                } else {
                    break;
                }
            }
            max = Math.max(max, end - start);
            while (start < end && map.size() >= 2) {
                char head = s.charAt(start);
                if (map.get(head) == 1) {
                    map.remove(head);
                } else {
                    map.put(head, map.get(head)  - 1);
                }
                start++;
            }
        }
        return max;
    }
}