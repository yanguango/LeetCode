public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append((char)(65  + (n - 1) % 26));
            n = (n - 1) / 26;
        }
        return sb.reverse().toString();
    }
}
