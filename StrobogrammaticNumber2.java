public class Solution {
    public List<String> findStrobogrammatic(int n) {
        char[] array = new char[n];
        char[][] pairs = {{'0', '0'}, {'1', '1'}, {'8', '8'}, {'6', '9'}, {'9', '6'}};
        List<String> res = new ArrayList<>();
        dfs(array, 0, n - 1, res, pairs);
        return res;
    }

    public void dfs(char[] array, int low, int high, List<String> res, char[][] pairs) {
        if (low > high) {
            res.add(new String(array));
            return;
        }
        for (int i = 0; i < pairs.length; i++) {
            char[] pair = pairs[i];
            if (low == 0 && array.length != 1 && pair[0] == '0') continue;
            if (low == high && pair[0] != pair[1]) continue;
            array[low] = pair[0];
            array[high] = pair[1];
            dfs(array, low + 1, high - 1, res, pairs);
        }
    }
}