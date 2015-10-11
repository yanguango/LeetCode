public class Solution {
    public int climbStairs(int n) {
        if(n < 3) return n;
        int steps1 = 1;
        int steps2 = 2;
        for(int i = 3; i <= n; i++) {
            int steps = steps1 + steps2;
            steps1 = steps2;
            steps2 = steps;
        }
        return steps2;
    }
}