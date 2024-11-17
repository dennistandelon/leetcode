class Solution(object):
    def minimumSubarrayLength(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        lenn = len(nums)
        freq = [0 for i in range(32)]

        i = 0;
        j = 0;
        total = 0;
        result = float('inf')

        while j < lenn:
            total = total | nums[j]

            for p in range(32) :
                val = (1 << p) & nums[j]
                if val != 0:
                    freq[p] = freq[p] + 1
                

            while total >= k and j >=i:
                for p in range(32):
                    a = (1<<p)
                    val =(a & nums[i])
       
                    if val != 0:
                        freq[p] = freq[p] - 1
                        if freq[p] == 0:
                             total = (total ^ a)
                        
                result = min(result , j-i+1);
                i = i + 1
            j = j + 1

        return result if result != float('inf') else -1