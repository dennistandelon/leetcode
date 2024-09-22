class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int len = words.length;
        int falseCount = 0;
        for(int i=0; i < len; i++){
            int len2 = words[i].length();
            for(int j = 0; j < len2; j++){
                if(!allowed.contains("" + words[i].charAt(j))){
                    falseCount++;
                    break;
                }
            }
        }

        return len - falseCount;
    }
}