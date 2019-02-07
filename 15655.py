import sys

def recursive(idx, answer):
    if len(answer) == m:
        print(str(answer)[1:-1].replace(',', ''))
        return

    elif len(answer) > m or idx == n:
        return

    else:
        recursive(idx+1, answer + [nums[idx]])
        recursive(idx+1, answer)


n, m = list(map(int, sys.stdin.readline().strip().split()))
nums = list(map(int, sys.stdin.readline().strip().split()))
nums.sort()
recursive(0, [])
