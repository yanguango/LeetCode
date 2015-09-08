public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] digits = new int[len1 + len2];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                digits[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }

        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int temp = digits[i];
            digits[i] = (digits[i] + carry) % 10;
            carry = (temp + carry) / 10;
        }

        int i = 0;
        while (i < digits.length && digits[i] == 0) i++;
        StringBuilder sb = new StringBuilder();
        for (; i < digits.length; i++) {
            sb.append(digits[i]);
        }
        if (sb.length() == 0) sb.append(0);
        return sb.toString();
    }
}
