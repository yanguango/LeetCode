public class RomanToInteger {
    public int romanToInt(String s) {
        if (s == null) return 0;
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length() && ctoi(s.charAt(i)) < ctoi(s.charAt(i + 1))) {
                num += ctoi(s.charAt(i + 1)) - ctoi(s.charAt(i));
                i++;
            } else {
                num += ctoi(s.charAt(i));
            }
        }
        return num;
    }

    public int ctoi(char c) {
        switch (c) {
        case 'I':
            return 1;
        case 'V':
            return 5;
        case 'X':
            return 10;
        case 'L':
            return 50;
        case 'C':
            return 100;
        case 'D':
            return 500;
        case 'M':
            return 1000;
        default:
            return 0;
        }
    }
}
