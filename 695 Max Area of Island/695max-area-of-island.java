class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length, cols = grid[0].length, maxArea = 0;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (grid[i][j] == 1 && !visited[i][j]) { 
                    maxArea= Math.max(maxArea, dfs(grid, i, j, visited));
                }
        return maxArea;
    }

    private static int dfs(int[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)      return 0;
        if (visited[i][j] || grid[i][j] == 0) 
            return 0;
        visited[i][j] = true;
        return 1+ dfs(grid, i + 1, j, visited)+ dfs(grid, i - 1, j, visited)
+ dfs(grid, i, j + 1, visited)+ dfs(grid, i, j - 1, visited);
    }
}