public class Solution {
    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    dfs(rooms, i - 1, j, 1);
                    dfs(rooms, i + 1, j, 1);
                    dfs(rooms, i, j - 1, 1);
                    dfs(rooms, i, j + 1, 1);
                }
            }
        }
    }

    public void dfs(int[][] rooms, int i, int j, int steps) {
        if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length
                || rooms[i][j] == -1 || rooms[i][j] == 0 || rooms[i][j] < steps) return;
        rooms[i][j] = steps;
        dfs(rooms, i - 1, j, steps + 1);
        dfs(rooms, i + 1, j, steps + 1);
        dfs(rooms, i, j - 1, steps + 1);
        dfs(rooms, i, j + 1, steps + 1);
    }
}
