import java.util.*;

public class ValidAnagram {
    // O(nlgn)
    public boolean isAnagram(String s, String t) {
        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();
        Arrays.sort(schars);
        Arrays.sort(tchars);
        return Arrays.equals(schars, tchars);
    }

    // O(n),O(n)
    public boolean isAnagram1(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, (map.containsKey(c) ? map.get(c) : 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) return false;
            else {
                int occurs = map.get(c);
                if (occurs > 1) map.put(c, occurs - 1);
                else map.remove(c);
            }
        }
        return map.isEmpty();
    }
}
