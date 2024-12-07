class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        int len = words.length;

        for(int i=0; i < len; i++){
            if(words[i].startsWith(searchWord)){
                return i + 1;
            }
        }       

        return -1;
    }
}