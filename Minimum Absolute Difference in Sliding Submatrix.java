import java.util.*;

class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int resRows = m - k + 1;
        int resCols = n - k + 1;
        int[][] ans = new int[resRows][resCols];

        for (int i = 0; i < resRows; i++) {
            for (int j = 0; j < resCols; j++) {
                ans[i][j] = getMinDiff(grid, i, j, k);
            }
        }
        return ans;
    }

    private int getMinDiff(int[][] grid, int r, int c, int k) {
        // Use a TreeSet to automatically sort and remove duplicate values
        TreeSet<Integer> distinctValues = new TreeSet<>();
        
        for (int i = r; i < r + k; i++) {
            for (int j = c; j < c + k; j++) {
                distinctValues.add(grid[i][j]);
            }
        }

        // If there's only one distinct value, the difference is 0 by definition
        if (distinctValues.size() < 2) return 0;

        int minDiff = Integer.MAX_VALUE;
        Integer prev = null;

        for (int val : distinctValues) {
            if (prev != null) {
                minDiff = Math.min(minDiff, val - prev);
            }
            prev = val;
        }

        return minDiff;
    }
}