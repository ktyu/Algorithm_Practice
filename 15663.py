import sys

def recursive(idx, answer):
    if idx == m:
        print(str(answer)[1:-1].replace(',', ''))
        return

    else:
        did = []
        for i in range(n):
            if used[i] or nums[i] in did:
                continue

            used[i] = True
            recursive(idx+1, answer + [nums[i]])
            used[i] = False
            did.append(nums[i])


n, m = list(map(int, sys.stdin.readline().strip().split()))
nums = list(map(int, sys.stdin.readline().strip().split()))
nums.sort()
used = [False] * n
recursive(0, [])
