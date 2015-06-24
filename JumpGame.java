public class JumpGame {
    public boolean canJump(int[] nums) {
        int pos = 0;
        int reach = 0;
        while (reach < nums.length - 1) {
            int nextReach = reach;
            for (; pos <= reach; pos++) {
                nextReach = Integer.max(pos + nums[pos], nextReach);
            }
            if (nextReach >= nums.length - 1) return true;
            if (nextReach == reach) return false;
            reach = nextReach;
        }
        return true;
    }
}