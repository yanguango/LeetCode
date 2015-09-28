public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) return "";
        if (numerator == 0) return "0";
        StringBuilder res = new StringBuilder();
        if ((numerator < 0) ^ (denominator < 0)) res.append("-");

        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        long quotient = num / den;
        res.append(quotient);

        long remainder = (num % den) * 10;
        if (remainder == 0) return res.toString();

        res.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (remainder > 0) {
            if (map.containsKey(remainder)) {
                int begin = map.get(remainder);
                res.insert(begin, "(");
                res.append(")");
                return res.toString();
            }
            res.append(remainder / den);
            map.put(remainder, res.length() - 1);
            remainder = (remainder % den) * 10;
        }
        return res.toString();

    }
}
