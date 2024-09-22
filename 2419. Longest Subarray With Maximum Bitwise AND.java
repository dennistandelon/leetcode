class Solution {
    public int longestSubarray(int[] nums) {
        
        int len = nums.length;
        
        int[] disNum = new int[100001];
        int max = nums[0];

        int disI = 0;
        disNum[disI++] = 0;

        for(int i=1; i < len; i++){
            if(nums[i] != nums[i-1]){
                if(nums[i] > max){
                    max = nums[i];
                }
                disNum[disI++] = i;
            }
        }

        if(disI == 1){
            return len;
        }

        int[] maxNum = new int[100001];
        int maxI = 0;

        for(int i=0; i < disI; i++){
            if(nums[disNum[i]] == max){
                maxNum[maxI++] = i;
            }
        }

        int maxSeq = 1;
        for(int i=0; i < maxI; i++){
            int temp = len;
            if(disNum[maxNum[i] + 1] != 0){
                temp = disNum[maxNum[i] + 1];
            }

            int count = temp - disNum[maxNum[i]];
            if(count > maxSeq){
                maxSeq = count;
            }
        }
        

        return maxSeq;
    }
}