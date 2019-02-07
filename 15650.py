import sys

def recursive(idx, answer):
    if len(answer) == m:
        print(str(answer)[1:-1].replace(',', ''))
        return

    elif len(answer) > m or idx > n-1:
        return

    else:
        recursive(idx+1, answer+[nums[idx]])
        recursive(idx+1, answer)


n, m = list(map(int, sys.stdin.readline().strip().split()))
nums = list(range(1, n+1))
answer = []
recursive(0, answer)
