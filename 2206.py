import sys
from collections import deque

n, m = map(int, sys.stdin.readline().strip().split())
square = []
for i in range(n):
    square.append(list(map(int, list(sys.stdin.readline().strip()))))

dx = [0, 1, -1, 0]
dy = [1, 0, 0, -1]

visited = [[[0 for _ in range(m)] for _ in range(n)] for _ in range(2)]
q = deque()

q.append((0, 0, 0)) # row, col, used
visited[0][0][0] = 1
visited[1][0][0] = 1

while len(q) != 0:
    tu = q.popleft()

    for i in range(4):
        x = tu[1] + dx[i]
        y = tu[2] + dy[i]

        # point should be reachable in map
        if 0 <= x < n and 0 <= y < m:

            # non-blocked, and not-visited
            if square[x][y] == 0 and visited[tu[0]][x][y] == 0:
                visited[tu[0]][x][y] = visited[tu[0]][tu[1]][tu[2]] + 1
                q.append((tu[0], x, y))

            # blocked, but still have chance
            if square[x][y] == 1 and tu[0] == 0 and visited[1][x][y] == 0:
                visited[1][x][y] = visited[0][tu[1]][tu[2]] + 1
                q.append((1, x, y))


nonUsed = 9999999999 if visited[0][n-1][m-1] == 0 else visited[0][n-1][m-1]
used = 9999999999 if visited[1][n-1][m-1] == 0 else visited[1][n-1][m-1]
if used == 9999999999 and nonUsed == 9999999999:
    print(-1)
else:
    print(min(nonUsed, used))
