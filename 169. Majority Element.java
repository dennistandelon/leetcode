class Solution {
    public int majorityElement(int[] nums) {
        HashMap<String,Integer> data = new HashMap<String,Integer>(0);

        int len = nums.length;

        int iMax = 0;
        data.put("0",0);

        String temp;
        for(int i=0; i < len; i++){
            temp = Integer.toString(nums[i]);
            if(data.get(temp) == null){
                data.put(temp, 0);
            }
            data.put(temp,data.get(temp) + 1);

            if(nums[i] != iMax && data.get(temp) > data.get(Integer.toString(iMax))){
                iMax = nums[i];
            }
        }   

        return iMax;
    }
}