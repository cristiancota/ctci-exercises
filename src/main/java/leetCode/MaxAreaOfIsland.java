package leetCode;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {

        int[][] seen = new int[grid.length][grid[0].length];
        int max = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                max = Math.max(max, dfs(i, j, grid, seen));
            }
        }

        return max;
    }

    public int dfs(int i, int j, int[][] grid, int[][] seen) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || seen[i][j] == 1 || grid[i][j] == 0) {
            return 0;
        }

        seen[i][j] = 1;

        return (1 +
                dfs(i + 1, j, grid, seen) +
                dfs(i - 1, j, grid, seen) +
                dfs(i, j - 1, grid, seen) +
                dfs(i, j + 1, grid, seen)
        );
    }
}


