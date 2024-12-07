class Solution {
    public boolean canChange(String start, String target) {
        int i = 0;
        int j = 0;
        int end_i = start.length();
        int end_j = target.length();

        while(i < end_i && j < end_j){

            if(start.charAt(i) == target.charAt(j)){
                if(start.charAt(i) == 'L' && j > i){
                    return false;
                }

                if(start.charAt(i) == 'R' && i > j){
                    return false;
                }

                i++;
                j++;
            } else if(start.charAt(i) == '_'){
                i++;
            } else if(target.charAt(j) == '_'){
                j++;
            } else{
                return false;
            }
        }

        while(i < end_i){
            if(start.charAt(i) == 'R' || start.charAt(i) == 'L'){
                return false;
            }
            i++;
        }


        while(j < end_j){
            if(target.charAt(j) == 'R' || target.charAt(j) == 'L'){
                return false;
            }
            j++;
        }

        return true;
    }
}