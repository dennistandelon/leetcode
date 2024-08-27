class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;

        int end = len - k;
        if(k > len){
            end = len - (k % len);
        }

        
        int[] arr = new int[100001];

        for(int i=0; i < len; i++){
            arr[i] = nums[i];
        }

        int start = 0;
        for(int i = end; i < len; i++){
            nums[start++] = arr[i];
        }

        for(int i = 0; i < end; i++){
            nums[start++] = arr[i];
        }

    }
}