import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (map.containsKey(key)) {
                map.get(key).add(s);
            } else {
                List<String> l = new ArrayList<>();
                l.add(s);
                map.put(key, l);
            }
        }
        for (List<String> l : map.values()) {
            Collections.sort(l);
            res.add(l);
        }
        return res;
    }
}
