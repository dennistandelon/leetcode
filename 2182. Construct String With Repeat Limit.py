class Solution(object):
    def repeatLimitedString(self, s, repeatLimit):
        """
        :type s: str
        :type repeatLimit: int
        :rtype: str
        """

        char_count = [0] * 26
      
        for c in s:
            char_count[ord(c) - ord('a')] += 1
      
        answer = []
        for i in range(25, -1, -1):
            next_char_index = i - 1
          
            while True:
                for _ in range(min(repeatLimit, char_count[i])):
                    char_count[i] -= 1
                    answer.append(chr(ord('a') + i))
              
                if char_count[i] == 0:
                    break
              
                while next_char_index >= 0 and char_count[next_char_index] == 0:
                    next_char_index -= 1
              
                if next_char_index < 0:
                    break
              
                char_count[next_char_index] -= 1
                answer.append(chr(ord('a') + next_char_index))
      
        return ''.join(answer)

        
        
        