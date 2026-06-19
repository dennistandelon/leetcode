class Solution {
    public String mapWordWeights(String[] words, int[] weights) {

        StringBuilder sb = new StringBuilder();
        int len = words.length;

        for(int i = 0; i < len; i++){
            int wordLen = words[i].length();
            int sum = 0;
            for(int j = 0; j < wordLen; j++){
                sum += weights[((int)words[i].charAt(j) - 97)];
            }

            sb.append((char)(26 - (sum % 26) - 1 + 97));
        }


        return sb.toString();
    }
}