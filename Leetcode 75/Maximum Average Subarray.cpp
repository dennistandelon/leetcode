class Solution {
public:
    double findMaxAverage(vector<int>& nums, int k) {
        int len = nums.size();
        double curr = 0;
        for(int x = 0; x < k; x++){
            curr += nums[x];
        }

        double max = curr;
        int startIdx = 0;
        for(int i = k; i < len; i ++){
            curr -= nums[startIdx++];
            curr += nums[i];  
            if(curr > max){
                max = curr;
            }
        }

        return max/k;
    }
};