class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] rnum = new int[27];
        int[] mnum = new int[27];

        int len1 = ransomNote.length();
        int len2 = magazine.length();
        
        for(int i=0; i < len1; i++){
            int n = ransomNote.charAt(i) - 'a';
            rnum[n]++;
        }

        for(int i=0; i < len2; i++){
            int n = magazine.charAt(i) - 'a';
            mnum[n]++;
        }

        for(int i=0; i < 27; i++){
            if(rnum[i] > mnum[i]){
                return false;
            }
        }


        return true;
    }
}