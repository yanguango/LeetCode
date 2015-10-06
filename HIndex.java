public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int hindex = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            int cit = citations[i];
            if (cit > hindex) hindex++;
            else break;
        }
        return hindex;
    }
}
