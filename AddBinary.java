public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int p1 = a.length() - 1;
        int p2 = b.length() - 1;
        int carry = 0;
        while (p1 >= 0 || p2 >= 0) {
            int d1 = p1 >= 0 ? a.charAt(p1--) - '0' : 0;
            int d2 = p2 >= 0 ? b.charAt(p2--) - '0' : 0;
            sb.append((d1 + d2 + carry) % 2);
            carry = (d1 + d2 + carry) / 2;
        }
        if (carry > 0) sb.append(1);
        return sb.reverse().toString();
    }
}
