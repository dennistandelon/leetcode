class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> ban = new HashSet<Integer>();

        for(int i: banned){
            if (i <= n){
                ban.add(i);
            }
        }

        ArrayList<Integer> ax = new ArrayList<Integer>();
        
        for(int i=1; i <= n; i++){
            if(ban.contains(i)){
                continue;
            }
            ax.add(i);
        }

        
        int total = 0;
        int count = 0;

        for(Integer i: ax){
            if(total + i <= maxSum){
                total += i;
                count++;
            }
        }
        
        return count;   
    }
}