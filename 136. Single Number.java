class Solution {
    public int singleNumber(int[] nums) {
        HashMap<String,Integer> mp = new HashMap<String,Integer>();
        int len = nums.length;
        for(int i=0; i < len; i++){
            if(mp.get(String.valueOf(nums[i])) == null){
                mp.put(String.valueOf(nums[i]), 1);
            } else{
                mp.put(String.valueOf(nums[i]), mp.get(String.valueOf(nums[i])) + 1);
            }
        }

        for(int i=0; i < len; i++){
            if(mp.get(String.valueOf(nums[i])) == 1){
                return nums[i];
            } 
        }

        return nums[0];
    }
}