class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int[] arr = new int[201];

        for(int i=0; i < len; i++){
            arr[nums[i]+100]++;
        }

        len = 0;
        int k = 0;
        for(int i=0; i <= 200; i++){
            if(arr[i] > 0) {
                nums[k++] = i-100;
                len++;
            }
        }

        return len;
    }
}