class Solution {

    public int findKthNumber(int n, int k) {
        int count = 1;
        k--;

        while(k > 0){
            int num = total(count,n);

            if (num <= k) {
                count++;
                k -= num;
            } else {
                count *= 10;
                k--;
            }

        }

        return count;
    }

    public int total(int x, int max){
        long curr = x;
        long next = curr + 1;
        int count = 0;

        while (curr <= max) {
            count += Math.min(max + 1, next) - curr;
            curr *= 10;
            next *= 10;
        }

        return count;
    }
}