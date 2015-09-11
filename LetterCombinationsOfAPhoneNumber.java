public class LetterCombinationsOfAPhoneNumber {
    private String[] mapping = new String[] {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.isEmpty()) return res;
        StringBuilder comb = new StringBuilder();
        dfs(digits, 0, res, comb);
        return res;
    }

    public void dfs(String digits, int index, List<String> res, StringBuilder comb) {
        if (index > digits.length() - 1) {
            res.add(comb.toString());
            return;
        }

        String letters = mapping[digits.charAt(index) - '0' - 2];
        for (int i = 0; i < letters.length(); i++) {
            comb.append(letters.charAt(i));
            dfs(digits, index + 1, res, comb);
            comb.deleteCharAt(comb.length() - 1);
        }
    }
}
