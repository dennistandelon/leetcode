class Solution {
    public String compressedString(String word) {
        String newWord = "";

        int len = word.length();
        int count = 1;
        char curr = word.charAt(0);
        for(int i=1; i <= len; i++){
            if( i == len){
                newWord += (count + "" + curr);
            } else if(curr != word.charAt(i) || count >= 9){
                newWord += (count + "" + curr);
                count = 1;
                curr = word.charAt(i);
            } else{
                count++;
            }
        }

        return newWord;
    }
}