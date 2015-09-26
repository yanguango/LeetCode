public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> part = new ArrayList<>();
        dfs(s, 0, res, part);
        return res;
    }

    public void dfs(String s, int start, List<List<String>> res, List<String> part) {
        if (start >= s.length()) {
            res.add(part);
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                List<String> newPart = new ArrayList<>(part);
                newPart.add(s.substring(start, i + 1));
                dfs(s, i + 1, res, newPart);
            }
        }
    }

    public boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}
