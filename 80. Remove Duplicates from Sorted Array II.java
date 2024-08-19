class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int[] arr = new int[20001];

        for(int i=0; i < len; i++){
            arr[nums[i]+10000]++;
        }

        len = 0;
        int k = 0;
        for(int i=0; i <= 20000; i++){
            int sum = arr[i];
            if(sum > 0) {
                nums[k++] = i-10000;
                if(sum > 1){
                    nums[k++] = i-10000;
                    len++;
                }
                len++;
            }
        }

        return len;
    }
}