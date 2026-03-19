class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Empty string matches empty pattern
        dp[0][0] = true;

        // Handle patterns like a*, a*b*, or .* which can match an empty string
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sChar = s.charAt(i - 1);
                char pChar = p.charAt(j - 1);

                if (pChar == '.' || pChar == sChar) {
                    // Case 1: Characters match or pattern has '.'
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pChar == '*') {
                    // Case 2: Pattern has '*'
                    // Subcase A: Match zero of the preceding element (skip x*)
                    dp[i][j] = dp[i][j - 2];

                    // Subcase B: Match one or more if the preceding element matches s[i-1]
                    char prevPChar = p.charAt(j - 2);
                    if (prevPChar == '.' || prevPChar == sChar) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }

        return dp[m][n];
    }
}