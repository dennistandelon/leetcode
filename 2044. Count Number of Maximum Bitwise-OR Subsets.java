class Solution {

    int count = 0;
    int len = 0;

    public int countMaxOrSubsets(int[] nums) {
        int max_bit = 0;

        this.len = nums.length;
        for(int i=0; i < len; i++){
            max_bit = max_bit | nums[i];
        }        

        recursive(0,0,max_bit, nums);
        return this.count;
    }

    public void recursive(int curr, int index, int max_bit, int[] nums){

        if(index == this.len){
            return;
        }
        
        int temp = curr | nums[index];

        if(temp == max_bit){
            this.count++;
        }

        recursive(curr, index+1, max_bit, nums); // not taken
        recursive(temp, index+1, max_bit, nums); // taken

    }
}