class Solution {
    public int myAtoi(String s) {
        if (s == null || s.isEmpty()) return 0;

        int n = s.length();
        int i = 0;

        // 1. Ignore leading whitespace
        while (i < n && s.charAt(i) == ' ') i++;
        if (i == n) return 0;

        // 2. Determine signedness
        int sign = 1;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // 3. Conversion with Rounding (Overflow Check)
        int result = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // Check for overflow before updating result
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return result * sign;
    }
}