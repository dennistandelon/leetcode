class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int len = nums.length;

        int totalAll = 0;
        int sum = 0;
        int min = len;

        for(int i=0; i < len; i++){
            sum += nums[i];
            totalAll += nums[i];
        
            while (sum >= target) {
                min = Math.min(min, i - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        if(totalAll < target){
            return 0;
        }

        return min;
    }
}