public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        int cycle = numRows + numRows - 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            if (i == 0 || cycle - i == i) {
                for (int j = i; j < s.length(); j += cycle) sb.append(s.charAt(j));
            } else {
                for (int j = 0; j < s.length(); j += cycle) {
                    if (j + i < s.length()) sb.append(s.charAt(j + i));
                    if (j + cycle - i < s.length()) sb.append(s.charAt(j + cycle - i));
                }
            }
        }
        return sb.toString();
    }
}
