class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        
        // Apply operations
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }
        
        // Shift zeros to the end
        int nonZero = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                // Swap elements
                int temp = nums[nonZero];
                nums[nonZero] = nums[i];
                nums[i] = temp;
                nonZero++;
            }
        }
        
        return nums;
    }
}

// Test class
class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        int[] nums1 = {1, 2, 2, 1, 1, 0};
        int[] result1 = solution.applyOperations(nums1);
        assert result1[0] == 1 && result1[1] == 4 && result1[2] == 2 && 
               result1[3] == 0 && result1[4] == 0 && result1[5] == 0;
        
        // Test case 2
        int[] nums2 = {0, 1};
        int[] result2 = solution.applyOperations(nums2);
        assert result2[0] == 1 && result2[1] == 0;
        
        System.out.println("All test cases passed!");
    }
} 