class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        
        int len = nums.length;
        

        for(int i = 0; i < k; i++){
            int minIndex = 0;
            int min = nums[minIndex];

            for(int j=0; j < len; j++){
                if(min > nums[j]){
                    min = nums[j];
                    minIndex = j;
                }
            }

            nums[minIndex] *= multiplier;
        }

        return nums;
    }
}