import java.util.*;

class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxArea = 0;

        // Step 1: Precompute heights of consecutive 1s for each column
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }
        }

        // Step 2: For each row, sort heights and calculate max area
        for (int i = 0; i < m; i++) {
            int[] currentRow = matrix[i].clone();
            Arrays.sort(currentRow);

            // Calculate area from right (tallest) to left (shortest)
            for (int j = n - 1; j >= 0; j--) {
                int height = currentRow[j];
                int width = n - j;
                maxArea = Math.max(maxArea, height * width);
            }
        }

        return maxArea;
    }
}