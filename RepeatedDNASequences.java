import java.util.*;

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 11) return res;

        Map<Integer, Integer> map = new HashMap<>();
        Map<Character, Integer> charMap = new HashMap<>();
        charMap.put('A', 0);
        charMap.put('C', 1);
        charMap.put('G', 2);
        charMap.put('T', 3);

        int substrInt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < 9) {
                substrInt = (substrInt << 2) + charMap.get(s.charAt(i));
            } else {
                substrInt = (substrInt << 2) + charMap.get(s.charAt(i));
                map.put(substrInt, (map.containsKey(substrInt) ? map.get(substrInt) : 0) + 1);
                if (map.get(substrInt) == 2) res.add(s.substring(i - 9, i + 1));
                substrInt = substrInt & ((1 << 18) - 1);
            }
        }
        return res;
    }
}
