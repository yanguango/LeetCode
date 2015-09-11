public class ReverseWordsInAString2 {
    public void reverseWords(char[] s) {
        int start = 0, end = 0;
        while (start < s.length) {
            while (end < s.length && s[end] != ' ') end++;
            int i = start, j = end - 1;
            while (i < j) {
                char temp = s[i];
                s[i++] = s[j];
                s[j--] = temp;
            }
            start = ++end;
        }

        start = 0;
        end = s.length - 1;
        while (start < end) {
            char temp = s[start];
            s[start++] = s[end];
            s[end--] = temp;
        }
    }
}
