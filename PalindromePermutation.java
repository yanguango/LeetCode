public class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        int oddChars = 0;
        for (int n : map.values()) {
            if (n % 2 == 1) oddChars++;
            if (oddChars > 1) return false;
        }
        return true;
    }
}