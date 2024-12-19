class Solution {
    public long continuousSubarrays(int[] nums) {
        long totalCount = 0;
        
        int windowStart = 0;
        int n = nums.length;
        
        TreeMap<Integer, Integer> frequencyMap = new TreeMap<>();

        
        for (int windowEnd = 0; windowEnd < n; ++windowEnd) {
        
            frequencyMap.merge(nums[windowEnd], 1, Integer::sum);
            while (frequencyMap.lastEntry().getKey() - frequencyMap.firstEntry().getKey() > 2) {
                frequencyMap.merge(nums[windowStart], -1, Integer::sum);
                if (frequencyMap.get(nums[windowStart]) == 0) {
                    frequencyMap.remove(nums[windowStart]);
                }
                ++windowStart;
            }
            
            totalCount += windowEnd - windowStart + 1;
        }
        
        return totalCount;
    }
}