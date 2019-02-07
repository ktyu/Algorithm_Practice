import sys

def recursive(idx, answer):
    if idx == m:
        print(str(answer)[1:-1].replace(',', ''))
        return

    else:
        for i in range(n):
            if idx > 0 and answer[idx-1] > nums[i]:
                continue
            recursive(idx+1, answer + [nums[i]])


n, m = list(map(int, sys.stdin.readline().strip().split()))
nums = list(map(int, sys.stdin.readline().strip().split()))
nums.sort()
recursive(0, [])
