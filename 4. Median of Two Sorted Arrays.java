class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int i = 0;
        int j = 0;
        int k = 0;

        int[] newArr = new int[2001];
        while(i < len1 && j < len2){
            if(nums1[i] < nums2[j]){
                newArr[k] = nums1[i++];
            } else{
                newArr[k] = nums2[j++];
            }
            k++;
        }

        while(i < len1){
            newArr[k++] = nums1[i++];
        }

        while(j < len2){
            newArr[k++] = nums2[j++];
        }

        int newLen = len1 + len2;
    
        int mean1 = (int)Math.floor(newLen/2);
        if(newLen % 2 == 1){
            return newArr[mean1];
        }

        int mean2 = (int)Math.floor(newLen/2) - 1;

        return ((double)(newArr[mean1] + newArr[mean2]))/2;
    }
}