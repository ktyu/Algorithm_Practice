import sys
from collections import deque

r, c = map(int, sys.stdin.readline().strip().split())

water = [[0 for __ in range(c)] for _ in range(r)]
queue = deque()
alive = deque()

for i in range(r):
    row = list(sys.stdin.readline().strip())
    for j in range(c):
        if row[j] == '.':
            pass # 물이 없는 곳은 0 그대로

        elif row[j] == '*':
            water[i][j] = 1 # 물이 들어 찬 곳
            queue.append((i, j)) # 물은 범람시켜야 하므로 큐에 저장

        elif row[j] == 'X':
            water[i][j] = -1 # 막힌 곳(돌)은 -1

        elif row[j] == 'D':
            water[i][j] = -1 # 목적지도 물 입장에선 막힌 곳
            goal = (i, j) # 목적지

        elif row[j] == 'S':
            alive.append((i, j)) # 살아남아있는 고슴도치들의 위치

dx = [0, 1, -1, 0]
dy = [1, 0, 0, -1]
moved = 0

# 큐들에 원소가 한개라도 있으면 진행
while len(queue) + len(alive) > 0:

    # 물 범람 1회 진행
    nextQueue = deque()
    while len(queue) != 0:
        tu = queue.popleft()
        for i in range(4):
            x = tu[0] + dx[i]
            y = tu[1] + dy[i]

            # 맵 안이고, 물이 범람할 수 있는 곳이면, 물이 들어참
            if 0 <= x < r and 0 <= y < c and (water[x][y] == 0 or water[x][y] == 2):
                water[x][y] = 1
                nextQueue.append((x, y))
    queue = nextQueue

    # 고슴도치 1보 전진
    if len(alive) == 0:
        print("KAKTUS")
        exit(0)

    moved += 1
    nextAlive = deque()
    while len(alive) != 0:
        tu = alive.popleft()

        for i in range(4):
            x = tu[0] + dx[i]
            y = tu[1] + dy[i]

            # 목적지 도착 여부 검사
            if (x, y) == goal:
                print(moved)
                exit(0)

            # 맵 안이고 물이 없으면 전진
            if 0 <= x < r and 0 <= y < c and water[x][y] == 0:
                water[x][y] = 2 # 이미 지나온곳은 다시 갈필요 없으므로
                nextAlive.append((x, y))

    alive = nextAlive

print("KAKTUS")
