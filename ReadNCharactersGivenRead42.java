/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private char[] buffer = new char[4];
    private int offset = 0; // offset of buffer next time get start from
    private int remain = 0; // remained chars in buffer

    public int read(char[] buf, int n) {
        int count = 0;
        boolean eof = false;
        while (count < n && !eof) {
            // if there is no remained char, read4
            if (remain == 0) {
                remain = read4(buffer);
                if (remain < 4) eof = true;
            }
            // each time read from buffer until reach n
            int nread = Math.min(n - count, remain);
            System.arraycopy(buffer, offset, buf, count, nread);
            // offset will move to right, if reach end then back to 0
            offset = (offset + nread) % 4;
            remain -= nread;
            count += nread;
        }
        return count;
    }
}
