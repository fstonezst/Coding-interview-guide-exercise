import sys
from enum import Enum


class Action(Enum):
    # python 枚举
    no = 0
    lToM = 1
    mToL = 2
    mToR = 3
    rToM = 4


def hanoiPrblem(left, mid, right):
    left.insert(0, sys.maxint)
    num = len(left)
    if num <= 0: return 0
    mid.append(sys.maxint)
    right.append(sys.maxint)
    aRecord = [Action.no]
    step = 0
    while len(right) < num:
        step += fStackTotStack(aRecord, Action.lToM, Action.mToL, mid, left, 'mid', 'left')
        step += fStackTotStack(aRecord, Action.mToL, Action.lToM, left, mid, 'left', 'mid')
        step += fStackTotStack(aRecord, Action.rToM, Action.mToR, mid, right, 'mid', 'right')
        step += fStackTotStack(aRecord, Action.mToR, Action.rToM, right, mid, 'right', 'mid')
    return step


def fStackTotStack(action, preNoAct, nowAct, fStack, tStack, fr, to):
    if preNoAct != action[0] and fStack[-1] < tStack[-1]:
        tStack.append(fStack.pop())
        action[0] = nowAct
        print 'move %d from %s to %s' % (tStack[-1], fr, to)
        return 1
    else:
        return 0
