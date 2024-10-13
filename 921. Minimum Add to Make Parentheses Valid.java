class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0;
        int close = 0;
        int len = s.length();

        for(int i=0; i < len; i++){
            if(s.charAt(i) == '('){
                open++;
            } else if(s.charAt(i) == ')' && open > 0){
                open--;
            } else{
                close++;
            }
        }

        return open + close;
    }
}