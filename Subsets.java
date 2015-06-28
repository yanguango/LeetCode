public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        for(int i = 0; i < nums.length; i++) {
            int temp_size = res.size();
            for(int j = 0; j < temp_size; j++) {
                ArrayList<Integer> subset = new ArrayList<>(res.get(j));
                subset.add(nums[i]);
                res.add(subset);
            }
        }
        return res;
    }
}