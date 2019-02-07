import sys

def recursive(idx):
    if idx == m:
        print(str(answer)[1:-1].replace(',', ''))
        return

    else:
        for i in range(1, n+1):
            if used[i]:
                continue
            answer[idx] = i
            used[i] = True
            recursive(idx+1)
            used[i] = False


input_list = list(map(int, sys.stdin.readline().strip().split()))
n = input_list[0]
m = input_list[1]

used = [False]*(n+1)
answer = [0]*m

recursive(0)
