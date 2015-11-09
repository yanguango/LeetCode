public class Solution {
    public int minArea(char[][] image, int x, int y) {
        int rows = image.length;
        int cols = image[0].length;
        int[] borders = {rows, -1, -1, cols};
        dfs(image, x, y, borders);
        return (borders[2] - borders[0] + 1) * (borders[1] - borders[3] + 1);
    }

    public void dfs(char[][] image, int i, int j, int[] borders) {
        if (i < 0 || i >= image.length
                || j < 0 || j >= image[0].length
                || image[i][j] != '1') return;

        borders[0] = Math.min(borders[0], i);
        borders[1] = Math.max(borders[1], j);
        borders[2] = Math.max(borders[2], i);
        borders[3] = Math.min(borders[3], j);
        image[i][j] = '2';
        dfs(image, i - 1, j, borders);
        dfs(image, i + 1, j, borders);
        dfs(image, i, j - 1, borders);
        dfs(image, i, j + 1, borders);
    }
}