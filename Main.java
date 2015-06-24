import java.util.List;

public class Main {
    public static void main(String[] args) {
        // write your code here
        ThreeSum sol = new ThreeSum();
        int[] nums = new int[] {0, -4, -1, -4, -2, -3, 2};
        List<List<Integer>> res = sol.threeSum(nums);
        System.out.println(res.size());
    }
}
