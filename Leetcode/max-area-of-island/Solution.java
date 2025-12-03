class Solution {
    int m, n;
    public int maxAreaOfIsland(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int max = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    max = Math.max(dfs(i, j, grid), max);
                }
            }
        }
        return max;
    }

    int dfs(int i, int j, int[][] grid) {
        if(i < 0 || j < 0 || i == n || j == m || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = 0;
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int area = 1;
        for(int[] dir: dirs) {
            area += dfs(i + dir[0], j + dir[1], grid);
        }
        return area;
    }
}
