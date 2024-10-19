class Solution(object):
    def maximumSwap(self, num):
        """
        :type num: int
        :rtype: int
        """
        num_str = list(str(num))
    
        last = {int(x): i for i, x in enumerate(num_str)}
        
        for i, digit in enumerate(num_str):
            for d in range(9, int(digit), -1):
                if last.get(d, -1) > i:
                    num_str[i], num_str[last[d]] = num_str[last[d]], num_str[i]
                    return int(''.join(num_str))
        
        return num