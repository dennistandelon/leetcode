class Solution {
    public int minBitFlips(int start, int goal) {
        int x = start ^ goal;

        int sum = 0;
        while(x > 0){
            if(x % 2 == 1){
                sum++;
            }
            x /= 2;
        }

        return sum;
    }
}