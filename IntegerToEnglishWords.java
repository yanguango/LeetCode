public class Solution {
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        int billions = num / 1000000000;
        num = num % 1000000000;
        int millions = num / 1000000;
        num = num % 1000000;
        int thousands = num / 1000;
        num = num % 1000;
        StringBuilder  sb = new StringBuilder();
        if (billions > 0) sb.append(numberToWordsUnderThousand(billions) + " Billion ");
        if (millions > 0) sb.append(numberToWordsUnderThousand(millions) + " Million ");
        if (thousands > 0) sb.append(numberToWordsUnderThousand(thousands) + " Thousand ");
        if (num > 0) sb.append(numberToWordsUnderThousand(num));
        return sb.toString().trim();
    }

    public String numberToWordsUnderThousand(int num) {
        int hundreds = num / 100;
        num = num % 100;
        int tens = num / 10;
        num = num % 10;
        StringBuilder  sb = new StringBuilder();
        String[] tenWords = new String[] {"Twenty", "Thirty", "Forty", "Fifty",
                                          "Sixty", "Seventy", "Eighty", "Ninety"
                                         };
        String[] words = new String[] {"One", "Two", "Three", "Four", "Five",
                                       "Six", "Seven", "Eight", "Nine", "Ten",
                                       "Eleven", "Twelve", "Thirteen", "Fourteen",
                                       "Fifteen", "Sixteen", "Seventeen",
                                       "Eighteen", "Nineteen"
                                      };
        if (hundreds > 0) sb.append(words[hundreds - 1] + " Hundred ");
        if (tens > 1) {
            sb.append(tenWords[tens - 2] + " ");
            if (num > 0) sb.append(words[num - 1]);
        } else if (tens * 10 + num > 0) {
            sb.append(words[tens * 10 + num - 1]);
        }
        return sb.toString().trim();
    }
}
