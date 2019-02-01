import copy

n = int(input())
m = int(input())

if n<1:
    print('0')
    
elif m<1:
    print('1')

else:
    map = []
    row = [0]*n

    for i in range(n):
        new_row = copy.deepcopy(row)
        new_row[i] = 1
        map.append(new_row)
        
    for i in range(m):
        d = input().strip().split()
        map[int(d[0])-1][int(d[1])-1] = 1
        map[int(d[1])-1][int(d[0])-1] = 1

    queue = [0]
    visited = []

    while len(queue) != 0:

        now = queue.pop(0)
        if now in visited:
            continue
        
        visited.append(now)

        for i in range(n):
            if i != now and map[now][i] == 1 and not(i in visited):
                queue.append(i)


    print(len(visited)-1)
