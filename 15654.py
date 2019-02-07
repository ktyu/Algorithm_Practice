import sys

def recursive(idx):
    if idx == m:
        print(str(answer)[1:-1].replace(',', ''))
        return

    else:
        for i in range(n):
            if used[i]:
                continue
            answer[idx] = nums[i]
            used[i] = True
            recursive(idx+1)
            used[i] = False

n, m = list(map(int, sys.stdin.readline().strip().split()))
nums = list(map(int, sys.stdin.readline().strip().split()))
nums.sort()
answer = [0] * m
used = [False] * n
recursive(0)
