class Solution(object):
    def removeSubfolders(self, folder):
        """
        :type folder: List[str]
        :rtype: List[str]
        """
        folder.sort()
        result = []
        prev = ""
        for f in folder:
            print(f)
            if not result or result[-1].split('/') != f.split('/')[:len(result[-1].split('/'))]:
                result.append(f)
                prev = f  
        
        return result

        

