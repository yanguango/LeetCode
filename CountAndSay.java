public class CountAndSay {
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 0; i < n - 1; i++) s = say(s);
        return s;
    }

    public String say(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char c = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == c) count++;
            else {
                sb.append(count);
                sb.append(c);
                count = 1;
                c = s.charAt(i);
            }
        }
        sb.append(count);
        sb.append(c);
        return sb.toString();
    }
}
