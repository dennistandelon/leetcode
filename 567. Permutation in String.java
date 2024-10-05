class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        int len1 = s1.length();
        int len2 = s2.length();

        if(len2 < len1){
            return false;
        }

        for(int i=0; i < len1; i++){
            int idx1 = s1.charAt(i) - 'a';
            int idx2 = s2.charAt(i) - 'a';
            freq1[idx1]++; 
            freq2[idx2]++; // initial count of window s2 
        }

        int max = len2 - len1 - 1;
        int same = 0;

        for(int i=0; i < 26; i++){
            if(freq2[i] == freq1[i]) same++;
        }

        if(same == 26){
            return true;
        }

        for(int i = 0; i <= max; i++){
            int idxBef = s2.charAt(i) - 'a';
            int idxAft = s2.charAt(len1+i) - 'a';
            
            freq2[idxBef]--;
            freq2[idxAft]++;
            
            same = 0;
            
            for(int j=0; j < 26; j++){
                if(freq2[j] == freq1[j]) {
                    same++;
                }
            }

            if(same == 26){
                return true;
            }
        }

        return false;
    }
}