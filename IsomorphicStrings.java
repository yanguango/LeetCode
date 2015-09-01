import java.util.*;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!map1.containsKey(s.charAt(i))) {
                map1.put(s.charAt(i), t.charAt(i));
            } else {
                if (map1.get(s.charAt(i)) != t.charAt(i)) return false;
            }

            if (!map2.containsKey(t.charAt(i))) {
                map2.put(t.charAt(i), s.charAt(i));
            } else {
                if (map2.get(t.charAt(i)) != s.charAt(i)) return false;
            }
        }
        return true;
    }
}
