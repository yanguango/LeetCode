public class JumpGame2 {
    public int jump(int[] nums) {
        int jumps = 0;
        int last_reach = 0;
        int current_reach = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > last_reach) {
                last_reach = current_reach;
                jumps++;
            }
            current_reach = Integer.max(current_reach, i + nums[i]);
        }
        return jumps;
    }
}