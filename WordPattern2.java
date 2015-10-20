public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        if (pattern.length() == 0 && str.length() == 0) return true;
        else if (!(pattern.length() != 0 && str.length() != 0)) return false;

        Map<Character, String> map = new HashMap<>();
        return dfs(pattern, 0, str, 0, map);
    }

    public boolean dfs(String pattern, int match, String str, int start,
                       Map<Character, String> map) {
        if (match == pattern.length()) {
            return start == str.length();
        }

        char c = pattern.charAt(match);
        if (map.containsKey(c)) {
            String matched = map.get(c);
            int end = start + matched.length();
            return end <= str.length()
                   && str.substring(start, end).equals(matched)
                   && dfs(pattern, match + 1, str, end, map);
        } else {
            for (int end = start + 1; end <= str.length(); end++) {
                String substr = str.substring(start, end);
                if (!map.containsValue(substr)) {
                    map.put(c, substr);
                    if (dfs(pattern, match + 1, str, end, map)) return true;
                    map.remove(c);
                }
            }
            return false;
        }
    }
}