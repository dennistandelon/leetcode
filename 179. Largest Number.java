class Solution {
    public String largestNumber(int[] nums) {
        int len = nums.length;

        for(int i=0; i < len - 1; i++){
            for(int j=0; j < len - 1 - i; j++){
                if(compareNum(nums[j], nums[j+1])){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }

        String result = "";
        for(int i=0; i < len; i++){
            result += nums[i];
        }

        if(result.charAt(0) == '0'){
            return "0";
        }

        return result;
    }

    boolean compareNum(int num1, int num2){

        if(num1 == num2) {
            return true;
        } 

        String t = "" + num1;
        String t2 = "" + num2;

        String comb1 = t + t2;
        String comb2 = t2 + t;
        
        if(comb1.compareTo(comb2) > 0){
            return false;
        }
        
        return true;
    }
}