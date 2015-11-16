public class Solution {

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] matrix = new int[m][n];
        int[] id = new int[m * n];
        int[] sz = new int[m * n];
        int[] count = {0};
        for (int i = 0; i < m * n; i++) {
            id[i] = i;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < positions.length; i++) {
            addLand(matrix, id, sz, positions[i][0], positions[i][1], count);
            res.add(count[0]);
        }
        return res;
    }

    public int find(int[] id, int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

    public void union(int[][] matrix, int[] id, int[] sz, int p, int q, int[] count) {
        int pRoot = find(id, p);
        int qRoot = find(id, q);
        if (pRoot == qRoot) return;
        if (sz[pRoot] < sz[qRoot]) {
            id[pRoot] = qRoot;
            sz[pRoot] += sz[qRoot];
        } else {
            id[qRoot] = pRoot;
            sz[qRoot] += sz[qRoot];
        }
        count[0]--;
    }

    public void addLand(int[][] matrix, int[] id, int[] sz, int x, int y, int[] count) {
        int n = matrix[0].length;
        matrix[x][y] = 1;
        int[][] dirs = {{ -1, 0}, {0, 1}, {1, 0}, {0, -1}};
        count[0]++;
        sz[x * n + y] = 1;
        for (int i = 0; i < dirs.length; i++) {
            int nx = x + dirs[i][0];
            int ny = y + dirs[i][1];
            if (nx < 0 || nx >= matrix.length || ny < 0 || ny >= matrix[0].length || matrix[nx][ny] != 1)
                continue;
            union(matrix, id, sz, n * x + y, n * nx + ny, count);
        }
    }
}