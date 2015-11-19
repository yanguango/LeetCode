public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (s.equals(t)) return false;
        if (s.length() == t.length()) {
            int distance = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) distance++;
                if (distance > 1) return false;
            }
            return true;
        } else if (Math.abs(s.length() - t.length()) == 1) {
            String shorter = s.length() < t.length() ? s : t;
            String longer = s.length() > t.length() ? s : t;
            for (int i = 0; i < longer.length(); i++) {
                String deleteOne = longer.substring(0, i) + longer.substring(i + 1);
                if (deleteOne.equals(shorter)) return true;
            }
            return false;
        } else {
            return false;
        }
    }
}