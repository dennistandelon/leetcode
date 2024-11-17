class Solution(object):
    def primeSubOperation(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        def sieve_of_eratosthenes(limit):
            
            is_prime = [True] * (limit + 1)
            is_prime[0] = is_prime[1] = False

            for i in range(2, int(limit**0.5) + 1):
                if is_prime[i]:
                    for j in range(i * i, limit + 1, i):
                        is_prime[j] = False

            primes = [i for i in range(2, limit) if is_prime[i]]
            return primes

        primes_below_1000 = sieve_of_eratosthenes(1000)

        prev = 0
        for i, num in enumerate(nums):
            for p in reversed(primes_below_1000):
                if num - p > prev:
                    nums[i] = num - p
                    break
            else:
                if num <= prev:
                    return False
                nums[i] = num
            prev = nums[i] 

        return True