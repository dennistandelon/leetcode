class Solution(object):
    def maxUniqueSplit(self, s):
        """
        :type s: str
        :rtype: int
        """
        def back_track(start, history):

            if start == len(s):
                return len(history)

            max_splits = 0
       
            for end in range(start + 1, len(s) + 1):
                substring = s[start:end]
                if substring not in history:
                    history.add(substring) 
                    max_splits = max(max_splits, back_track(end, history))
                    history.remove(substring)

            return max_splits

        return back_track(0, set())

            
        