public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int lastSpace = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') lastSpace = i;
        }
        if (lastSpace < 0) return s.length();
        else return s.length() - 1 - lastSpace;
    }
}
