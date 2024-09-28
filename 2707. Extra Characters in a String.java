class Solution {
    public int minExtraChar(String s, String[] dictionary) {

        int len = s.length();
        Set<String> dict = new HashSet<>();
        for(String word : dictionary) {
            dict.add(word);
        }
        
        int[] memo = new int[len + 1];
        
        for(int i = 0; i <= len; i++){
            memo[i] = i;  
        }
        
        
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                String substring = s.substring(i, j + 1);
                if (dict.contains(substring)) {
                    memo[j + 1] = Math.min(memo[j + 1], memo[i]);
                }
            }
            
            memo[i + 1] = Math.min(memo[i + 1], memo[i] + 1);
        }
        
        return memo[len]; // Minimum extra characters
    }
}