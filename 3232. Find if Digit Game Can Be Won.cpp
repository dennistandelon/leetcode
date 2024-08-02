class Solution {
public:
    bool canAliceWin(vector<int>& nums) {
        int len = nums.size();
        int single_t = 0;
        int double_t = 0;
        for(int i=0; i < len; i++){
            if(nums[i] < 10){
                single_t = single_t + nums[i];
            } else{
                double_t = double_t + nums[i];
            }
        }

        if(double_t > single_t || single_t > double_t){
            return true;
        }

        return false;
    }
};