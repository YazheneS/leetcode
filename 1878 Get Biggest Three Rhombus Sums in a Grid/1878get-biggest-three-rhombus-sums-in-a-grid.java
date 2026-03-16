import java.util.*;

class Solution {

    public int[] getBiggestThree(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                // size 0 rhombus
                set.add(grid[i][j]);

                // try bigger sizes
                for (int k = 1; i - k >= 0 && i + k < n && j - k >= 0 && j + k < m; k++) {

                    int sum = 0;

                    int r = i - k;
                    int c = j;

                    // down-right
                    for (int t = 0; t < k; t++)
                        sum += grid[r + t][c + t];

                    // down-left
                    for (int t = 0; t < k; t++)
                        sum += grid[r + k + t][c + k - t];

                    // up-left
                    for (int t = 0; t < k; t++)
                        sum += grid[r + 2 * k - t][c - t];

                    // up-right
                    for (int t = 0; t < k; t++)
                        sum += grid[r + k - t][c - k + t];

                    set.add(sum);
                }
            }
        }

        int[] ans = new int[Math.min(3, set.size())];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = set.pollLast();
        }

        return ans;
    }
}