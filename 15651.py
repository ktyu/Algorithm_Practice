import sys

def recursive(idx):
    if idx == m:
        print(str(answer)[1:-1].replace(',', ''))
        return

    else:
        for i in range(1, n+1):
            answer[idx] = i
            recursive(idx+1)


n, m = list(map(int, sys.stdin.readline().strip().split()))
answer = [0] * m
recursive(0)
