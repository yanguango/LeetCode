public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        List<String> res = new ArrayList<>();
        if (len < 4 || len > 12) return res;
        List<String> comb = new ArrayList<>();
        dfs(s, 0, res, comb);
        return res;
    }

    public void dfs(String s, int start, List<String> res, List<String> comb) {
        if (comb.size() == 4) {
            if (start == s.length())
                res.add(String.join(".", comb));
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (start + i <= s.length()) {
                String seg = s.substring(start, start + i);
                int n = Integer.valueOf(seg);
                if (seg.equals("0") || (seg.charAt(0) != '0' && n <= 255)) {
                    comb.add(seg);
                    dfs(s, start + i, res, comb);
                    comb.remove(comb.size() - 1);
                }
            }
        }
    }
}
