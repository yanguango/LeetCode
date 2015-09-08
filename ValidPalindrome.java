public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int low = 0;
        int hi = s.length() - 1;
        while (low < hi) {
            char c1 = Character.toLowerCase(s.charAt(low));
            char c2 = Character.toLowerCase(s.charAt(hi));
            if (!isAlphanumeric(c1)) low++;
            else if (!isAlphanumeric(c2)) hi--;
            else {
                if (c1 != c2) return false;
                low++;
                hi--;
            }
        }
        return true;
    }

    public boolean isAlphanumeric(char c) {
        return Character.isDigit(c) || Character.isLetter(c);
    }
}
