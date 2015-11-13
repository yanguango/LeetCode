public class Solution {
    public boolean isStrobogrammatic(String num) {
        int low = 0;
        int high = num.length() - 1;
        while (low <= high) {
            char ch1 = num.charAt(low++);
            char ch2 = num.charAt(high--);
            if (!isOK(ch1, ch2)) return false;
        }
        return true;
    }

    public boolean isOK(char ch1, char ch2) {
        return (ch1 == '8' && ch2 == '8')
               || (ch1 == '1' && ch2 == '1')
               || (ch1 == '0' && ch2 == '0')
               || (ch1 == '6' && ch2 == '9')
               || (ch1 == '9' && ch2 == '6');
    }
}