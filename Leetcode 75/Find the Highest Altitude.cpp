class Solution {
public:
    int largestAltitude(vector<int>& gain) {
        int len = gain.size();

        int max = 0;
        int before = 0;

        for(int i=0; i < len; i++){
            before = before + gain[i];
            if(before > max){
                max = before;
            }
        }

        return max;

    }
};