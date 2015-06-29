public class Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, 0, res, subset);
        return res;
    }

    public void dfs(int[] nums, int start, List<List<Integer>> res, List<Integer> subset) {
        res.add(new ArrayList<Integer>(subset));
        int used = Integer.MAX_VALUE;
        for(int i = start; i < nums.length; i++) {
            if(nums[i] != used) {
                subset.add(nums[i]);
                dfs(nums, i + 1, res, subset);
                subset.remove(subset.size() - 1);
                used = nums[i];
            }
        }
    }
}