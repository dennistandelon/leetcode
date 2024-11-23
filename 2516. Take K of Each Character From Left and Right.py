class Solution(object):
    def takeCharacters(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: int
        """
        chars = Counter(s)
      
        if any(chars[char] < k for char in "abc"):
            return -1

        max_length = start_index = 0

        lenn = len(s)

        for i in range(lenn):
            chars[s[i]] -= 1
       
            while chars[s[i]] < k:
                chars[s[start_index]] += 1 
                start_index += 1
          
            max_length = max(max_length, i - start_index + 1)
      
        return lenn - max_length