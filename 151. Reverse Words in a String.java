class Solution {
    public String reverseWords(String s) {
        String[] x = s.trim().split(" ");
        int len = x.length;

        String fin = x[len-1];
        for(int i = len - 2; i >= 0; i--){
            if(x[i].trim() != ""){
                fin = fin + " " + x[i];
            }
        }

        return fin;
    }
}