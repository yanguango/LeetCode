public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int column = 0;
        int m = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            column += m * (s.charAt(i) - 'A' + 1);
            m *= 26;
        }
        return column;
    }
}
