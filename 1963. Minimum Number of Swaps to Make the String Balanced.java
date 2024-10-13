class Solution {
    public int minSwaps(String s) {
        int len = s.length();

        int balance = 0;
        int max = 0;
        for(int i=0; i < len; i++){
            if(s.charAt(i) == '['){
                balance += 1;
            } else{
                balance += -1;
            }

            max = Math.min(max, balance);
        }

        return (-1 * max + 1)/2;
    }
}