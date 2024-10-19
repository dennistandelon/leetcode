class Solution {

    String memo[];
    String reverse[];

    public char findKthBit(int n, int k) {
        memo = new String[n];
        reverse = new String[n];

        String res = create(n-1);
        return res.charAt(k-1);
    }

    public String create(int i){

        if(i == 0){
            memo[0] = "0";
            return memo[0];
        }

        if(memo[i-1] == null){
            memo[i-1] = create(i-1);
        }

        if(reverse[i-1] == null){
            reverse[i-1] = inverse(i-1);
        }

        return memo[i-1]  + "1" + reverse[i-1];
    }

    public String inverse(int i){
        if(i == 0){
            reverse[0] = "1";
            return reverse[0];
        }

        if(reverse[i-1] == null){
            reverse[i-1] = inverse(i-1);
        }

        if(memo[i-1] == null){
            memo[i-1] = create(i-1);
        }

        return memo[i-1] + "0" + reverse[i-1];
    }
}