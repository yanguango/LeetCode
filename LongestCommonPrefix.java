public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            Character c = null;
            for (String s : strs) {
                if (i >= s.length()) return sb.toString();
                if (c == null) c = s.charAt(i);
                else if (s.charAt(i) != c.charValue()) return sb.toString();
            }
            sb.append(c);
            i++;
        }
    }
}
