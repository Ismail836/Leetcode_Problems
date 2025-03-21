class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        
        // Use nested loops to find the pair
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
         return new int[] {};
    }
}

class twoSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solution.twoSum(nums1, target1);
        assert result1[0] == 0 && result1[1] == 1;
        
    }
}