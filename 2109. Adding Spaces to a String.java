class Solution {
    public String addSpaces(String s, int[] spaces) {
        int len = s.length();

        StringBuilder newString = new StringBuilder("");
        int k = 0;
        int lenk = spaces.length;
        for(int i = 0; i < len; i++){
            if(k < lenk && i == spaces[k]){
                newString.append(" " + s.charAt(i));
                k++;    
            } else{
                newString.append(s.charAt(i));
            }
        }

        return newString.toString();
    }
}