class Solution {
    public int removeDuplicates(int[] nums) {
        // Edge case: If the array is empty, return 0
        if (nums.length == 0) {
            return 0;
        }
        
        // This pointer tracks the position to insert the next unique element
        int insertIndex = 1; 
        
        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // If the current element is different from the previous one, it's unique
            if (nums[i] != nums[i - 1]) {
                nums[insertIndex] = nums[i]; // Move it to the unique section
                insertIndex++;               // Increment the count of unique elements
            }
        }
        
        // insertIndex represents the total number of unique elements
        return insertIndex;
    }
}