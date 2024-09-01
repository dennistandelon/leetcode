class Solution {
    public int scoreOfString(String s) {
        int score = 0;
        int len = s.length();

        for(int i = 1; i < len; i++){
            int temp = (s.charAt(i) - s.charAt(i-1));

            if(temp < 0){
                temp *= -1;
            }

            score += temp;
        }

        return score;
    }
}