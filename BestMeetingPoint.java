public class Solution {
    public int minTotalDistance(int[][] grid) {
        List<Integer> X = new ArrayList<>();
        List<Integer> Y = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    X.add(j);
                    Y.add(i);
                }
            }
        }

        return getSteps(X) + getSteps(Y);
    }

    public int getSteps(List<Integer> list) {
        Collections.sort(list);
        int steps = 0;
        int start = 0, end = list.size() - 1;
        while (start < end) {
            steps += list.get(end--) - list.get(start++);
        }
        return steps;
    }
}