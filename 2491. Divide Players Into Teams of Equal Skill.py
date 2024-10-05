class Solution(object):
    def dividePlayers(self, skill):
        """
        :type skill: List[int]
        :rtype: int
        """
        
        skill.sort()
        len1 = len(skill) - 1
        len2 = (len(skill) / 2)

        sum = skill[len1] + skill[0]
        total = 0

        for i in range(len2):
            if skill[i] + skill[len1 - i] != sum:
                return -1
            total = total + (skill[i] * skill[len1 - i])

        return total