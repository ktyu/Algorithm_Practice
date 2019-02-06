import sys

s = 0
n = int(sys.stdin.readline().strip())

for i in range(n):
    arr = sys.stdin.readline().strip().split()

    if arr[0] == 'add':
        num = int(arr[1])
        s |= 1 << num

    elif arr[0] == 'remove':
        num = int(arr[1])
        s &= ~(1 << num)

    elif arr[0] == 'check':
        num = int(arr[1])
        if s & (1 << num) > 0:
            print(1)
        else:
            print(0)

    elif arr[0] == 'toggle':
        num = int(arr[1])
        s ^= (1 << num)

    elif arr[0] == 'all':
        s |= ~0

    elif arr[0] == 'empty':
        s = 0

    else:
        break
