/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] buffer = new char[4];
        int count = 0;
        int nread = 0;
        do {
            nread = read4(buffer);
            System.arraycopy(buffer, 0, buf, count, Math.min(nread, n - count));
            count += nread;
        } while (nread == 4 && count < n);
        return count > n ? n : count;
    }
}
