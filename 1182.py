import sys

global count
count = 0


def recursive(idx, arr):

    if idx == n:
        if sum(arr) == s and len(arr) > 0:
            global count
            count += 1
        return

    recursive(idx+1, arr+[nums[idx]])
    recursive(idx+1, arr)


n, s = list(map(int, sys.stdin.readline().strip().split()))
nums = list(map(int, sys.stdin.readline().strip().split()))
recursive(0, [])
print(count)
