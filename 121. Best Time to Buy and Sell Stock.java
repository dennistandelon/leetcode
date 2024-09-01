class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int max = 0;
        int diff = 0;

        for(int i = len - 1; i >= 0; i--){
            if(prices[i] >= max){
                max = prices[i];
            } else {
                diff = Math.max(max - prices[i], diff);
            }
        }


        return diff;
    }
}