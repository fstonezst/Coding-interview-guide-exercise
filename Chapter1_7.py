class abc:
    def maxSlidingWindow(self, nums, k):
        # leetcode:239
        # 优化解
        from collections import deque
        d = deque()
        out = []
        for i, v in enumerate(nums):
            while d and nums[d[-1]] < v:
                d.pop()
            d += i,
            if d[0] <= i - k:
                d.popleft()
            if i > k - 2:
                out += nums[d[0]],
        return out

    def myMaxSlidingWindow(self, nums, k):
        """
        自己想的
        leetcode:239
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        if not nums:
            return []
        maxList = [self.findMax(nums, 0, k - 1)]
        for i in xrange(1, len(nums) - k + 1):
            if i > maxList[-1]:
                maxList.append(self.findMax(nums, i, i + k - 1))
                continue
            if nums[i + k - 1] > nums[maxList[-1]]:
                maxList.append(i + k - 1)
            else:
                maxList.append(maxList[-1])
        return maxList

    def findMax(self, window, start, end):

        if not window:
            return -1
        maxValue = window[0]
        maxIndex = 0
        for i in range(start, end + 1):
            if window[i] > maxValue:
                maxValue = window[i]
                maxIndex = i
        return maxIndex
