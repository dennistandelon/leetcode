class Solution {
    public long minimumSteps(String s) {
        int len = s.length();

        long zeros = 0;
        long result = 0;

        char curr = s.charAt(0);
        for(int i=len-1; i >= 0; i--){
            if(s.charAt(i) == '0'){
                zeros++;
            }

            if(s.charAt(i) == '1'){
                result += zeros;
            }
        }

        return result;
    }
}