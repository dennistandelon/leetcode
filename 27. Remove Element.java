class Solution {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int[] numx = new int[len+1];
        
        int count = 0;
        for(int i=0; i < len; i++){
            if(nums[i] != val){
                numx[count++] = nums[i];
            }
        }

        for(int i = 0; i < count; i++){
            nums[i] = numx[i];
        }

        return count;
    }
}