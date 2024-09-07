class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        
        
        int[] result = new int[len+1];
        int count = 0;
        int add = 1;
        for(int i=len-1; i >= 0; i--){
            if((digits[i] + add) % 10 == 0 && digits[i] > 0){
                result[count++] = (digits[i] + add) % 10;
                add = 1;
                if(i == 0){
                    result[count++] = 1;
                }
            } else{
                result[count++] = (digits[i] + add);
                add = 0;
            }
        }

        int[] finalRes = new int[count];

        for(int i=0; i < count; i++){
            finalRes[i] = result[count-i-1];
        }
        
        
        return finalRes;
    }
}