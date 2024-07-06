class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        int len1 = nums1.size();
        int len2 = nums2.size();

        int size1 = 0;
        if(len2 == 0){
            return;
        }

        int start = len1 - len2;
        for(int j=0; j < len2; j++){
            nums1[start+j] = nums2[j];
        }
        
        for(int i=0; i < len1; i++){
            for(int j=0; j < len1 - 1; j++){
                if(nums1[j] > nums1[j+1]){
                    int temp = nums1[j];
                    nums1[j] = nums1[j+1];
                    nums1[j+1] = temp;
                }
            }
        }

    }
};