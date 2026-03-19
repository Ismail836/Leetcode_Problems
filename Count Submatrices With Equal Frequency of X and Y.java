class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        // diff[i][j] stores (count of X - count of Y) for submatrix (0,0) to (i,j)
        int[][] diff = new int[m][n];
        // hasX[i][j] stores (count of X) for submatrix (0,0) to (i,j)
        int[][] hasX = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = 0;
                int xCount = 0;
                
                if (grid[i][j] == 'X') {
                    val = 1;
                    xCount = 1;
                } else if (grid[i][j] == 'Y') {
                    val = -1;
                }

                // Apply 2D Prefix Sum formula: Current + Top + Left - TopLeft
                diff[i][j] = val;
                hasX[i][j] = xCount;

                if (i > 0) {
                    diff[i][j] += diff[i - 1][j];
                    hasX[i][j] += hasX[i - 1][j];
                }
                if (j > 0) {
                    diff[i][j] += diff[i][j - 1];
                    hasX[i][j] += hasX[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    diff[i][j] -= diff[i - 1][j - 1];
                    hasX[i][j] -= hasX[i - 1][j - 1];
                }

                // Condition 1: Submatrix (0,0) to (i,j) always contains (0,0)
                // Condition 2: diff == 0 means equal X and Y
                // Condition 3: at least one X
                if (diff[i][j] == 0 && hasX[i][j] > 0) {
                    count++;
                }
            }
        }

        return count;
    }
}