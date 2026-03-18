class Solution {

    public int countSubmatrices(int[][] grid, int k) {

        int n = grid.length;
        int m = grid[0].length;

        int ans = 0;

        int[][] prefixSum = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                prefixSum[i][j] = grid[i][j];

                if (i > 0)
                    prefixSum[i][j] += prefixSum[i - 1][j];

                if (j > 0)
                    prefixSum[i][j] += prefixSum[i][j - 1];

                if (i > 0 && j > 0)
                    prefixSum[i][j] -= prefixSum[i - 1][j - 1];

                if (prefixSum[i][j] <= k)
                    ans++;
            }
        }

        return ans;
    }
}