public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        // memorize if the substring from i to end can be broken
        boolean[] canBreak = new boolean[s.length() + 1];
        Arrays.fill(canBreak, true);
        dfs(s, 0, wordDict, res, list, canBreak);
        return res;
    }

    public void dfs(String s, int start, Set<String> wordDict, List<String> res, List<String> list, boolean[] canBreak) {
        if (start >= s.length()) {
            res.add(String.join(" ", list));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String word = s.substring(start, i + 1);
            // the searched word should be in dict, and the left tail can be broken
            if (wordDict.contains(word) && canBreak[i + 1]) {
                list.add(word);
                int before = res.size();
                dfs(s, i + 1, wordDict, res, list, canBreak);
                // if the size of result isn't changed, it indicates the tail can't be broken
                // next time the tail don't need to be searched
                if (res.size() == before) canBreak[i + 1] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
