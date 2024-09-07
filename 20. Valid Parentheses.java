class Solution {
    public boolean isValid(String s) {
        
        int len = s.length();

        ArrayList<Character> listClose = new ArrayList<Character>();
        for(int i=0; i < len; i++){
            Character curr = s.charAt(i);
            if(curr == '{' || curr == '(' || curr == '['){
                listClose.add(getClosed(s.charAt(i)));
            } else{
                if(listClose.size() == 0){
                    return false;
                }

                if(listClose.get(listClose.size() - 1) == curr){
                    listClose.remove(listClose.size() - 1);
                } else{
                    return false;
                }
            }
        }

        if(listClose.size() != 0){
            return false;
        }


        return true;
    }

    public Character getClosed(char c){
        if(c == '{') return '}';
        if(c == '[') return ']';
        return ')';
    }
}