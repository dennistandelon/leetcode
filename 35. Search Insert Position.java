class Solution {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;

        for(int x = 0; x < len; x++){
            if(nums[x] == target) return x;
            else if(target < nums[x]) return x;
        }

        return len;
    }
}