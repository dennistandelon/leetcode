class Solution {
    public boolean containsDuplicate(int[] nums) {
        int len = nums.length;
        int temp = -1;

        divide(nums, 0, len - 1);

        for(int i=0; i < len - 1; i++){
            System.out.println(nums[i]);
            if(nums[i] == nums[i+1]){
                return true;
            }
        }

        return false;
    }

    public void divide(int[] nums, int left, int right){
        
        if(left < right){
            int mid = (left + right)/2;
            divide(nums,left, mid);
            divide(nums,mid+1, right);
            conquer(nums, left, right, mid);
        }    

    }

    public void conquer(int[] nums, int left, int right, int mid){
        int leftSize = mid - left + 1;
        int rightSize = right - mid;
        int[] leftArr = new int[leftSize];
        int[] rightArr = new int[rightSize];

        for(int i = left; i <= mid; i++){
            leftArr[i-left] = nums[i];
        }

        for(int i = mid+1; i <= right; i++){
            rightArr[i-mid-1] = nums[i];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while(i < leftSize && j < rightSize){
            if(leftArr[i] < rightArr[j]){
                nums[k] = leftArr[i++];
            } else{
                nums[k] = rightArr[j++];
            }
            k++;
        }
        
        while(i < leftSize){
            nums[k++] = leftArr[i++];
        }

        while(j < rightSize){        
            nums[k++] = rightArr[j++];
        }

    }
}