public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length());
            sb.append('#');
            sb.append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> strs = new ArrayList<>();
        if (s.length() == 0) return strs;
        int start = 0;
        int end = 0;
        while (end < s.length()) {
            end++;
            if (s.charAt(end) == '#') {
                int len = Integer.valueOf(s.substring(start, end));
                strs.add(s.substring(end + 1, end + 1 + len));
                start = end + 1 + len;
                end = start;
            }
        }
        return strs;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
