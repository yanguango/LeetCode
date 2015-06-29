public class Subsets {
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

    public List<List<Integer>> subsetsDFS(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, 0, res, subset);
        return res;
    }

    public void dfs(int[] nums, int start, List<List<Integer>> res, List<Integer> subset) {
        res.add(new ArrayList<Integer>(subset));
        for(int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            dfs(nums, i + 1, res, subset);
            subset.remove(subset.size() - 1);
        }
    }

    public List<List<Integer>> subsetsDFSIterative(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> starts = new ArrayDeque<>();
        Deque<ArrayList<Integer>> intermed = new ArrayDeque<>();

        res.add(new ArrayList<Integer>());
        for(int i = 0; i < nums.length; i++) {
            starts.push(i);
            intermed.add(new ArrayList<Integer>(Arrays.asList(nums[i])));
            while(!starts.isEmpty()) {
                int start = starts.pop();
                List<Integer> subset = intermed.pop();
                res.add(subset);

                for(int j = nums.length - 1; j > start; j--) {
                    starts.push(j);
                    ArrayList<Integer> newSubset = new ArrayList<>(subset);
                    newSubset.add(nums[j]);
                    intermed.push(newSubset);
                }
            }
        }
        return res;
    }}
}