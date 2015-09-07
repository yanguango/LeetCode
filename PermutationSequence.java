public class PermutationSequence {
    public String getPermutation(int n, int k) {
        int fact = 1;
        // use a list to store all left numbers
        List<Integer> nums = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            fact *= i;
            nums.add(i);
        }
        // if k is larger than n!, process k first.
        k = (k - 1) % fact + 1;
        StringBuilder sb = new StringBuilder();
        for (int i = n; i > 0; i--) {
            // f is the factorial without the current number
            // use f to get which number should be next number
            int f = fact / i;
            // the index to indicate which number in the left numbers list
            int index = (k - 1) / f;
            sb.append(nums.get(index));
            // should remove every number has been used
            nums.remove(index);
            // update k, minus the number of permutations before
            k = k - index * f;
            fact = f;
        }
        return sb.toString();
    }
}
