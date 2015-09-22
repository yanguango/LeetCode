public class Solution {
    public List<Integer> grayCode(int n) {
        if (n == 0) return new ArrayList<>(Arrays.asList(0));
        if (n == 1) return new ArrayList<Integer>(Arrays.asList(0, 1));
        List<Integer> seq = grayCode(n - 1);
        int size = seq.size();
        int addtion = 1 << (n - 1);
        for (int i = size - 1; i >= 0; i--) {
            seq.add(addtion + seq.get(i));
        }
        return seq;
    }
}
