public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Arrays.sort(strings);
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            String s = strings[i];
            StringBuilder keySB = new StringBuilder();
            for (int j = 1; j < s.length(); j++) {
                keySB.append((s.charAt(j) - s.charAt(j - 1) + 26) % 26);
                keySB.append("-");
            }
            String key = keySB.toString();
            if (!map.containsKey(key)) map.put(key, new ArrayList<String>());
            map.get(key).add(s);
        }
        List<List<String>> res = new ArrayList<>();
        for (List<String> val : map.values()) {
            res.add(val);
        }
        return res;
    }
}