from collections import deque


def findSubArr(list, num):
    maxQ = deque(list[0])
    minQ = deque(list[0])
    s = 0
    res = 0
    while s < len(list):
        while i < len(list):
            while maxQ and list[i] >= maxQ[-1]:
                maxQ.pop()
            maxQ.append(i)
            while minQ and list[i] <= minQ[-1]:
                minQ.pop()
            minQ.append(i)

            if (list[maxQ[0]] - list[minQ[0]]) > num:
                break
            i += 1

        res += (i - s)
        if maxQ[0] == s:
            maxQ.popleft()
        if minQ[0] == s:
            minQ.popleft()
        s += 1
    return res
