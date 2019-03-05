### BOJ에서 python3으론 통과안되고 pypy3론 통과됨

import sys
from collections import deque

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

# points의 idx번째 원소를 출발점으로 해서, points 에 있는 모든 점들에 가는 비용을 리턴하는 함수
def getCost(map, idx, points):
    q = deque()
    cost = [[-1]*w for _ in range(h)] # bfs 탐색할때 쓸 지도
    points_cost = [-1]*len(points) # 리턴할 리스트 (주어진 점들에 가는데 필요한 비용)

    q.append(points[idx])
    cost[points[idx][0]][points[idx][1]] = 0
    points_cost[idx] = 0
    find_cnt = 1

    # 이미 연산한쪽은 채우고 cnt 조금이라도 늘리기
    for i in range(idx):
        points_cost[i] = graph[i][idx]
        find_cnt += 1

    # bfs로 map 전체 탐색
    while len(q) != 0:
        # 필요한 정보 다 찾았으면 그냥 끝내기
        if find_cnt == len(points):
            break

        now = q.popleft()

        for i in range(4):
            x = now[0] + dx[i]
            y = now[1] + dy[i]

            if 0<=x<h and 0<=y<w and map[x][y] != 'x' and cost[x][y] == -1:
                cost[x][y] = cost[now[0]][now[1]] + 1
                q.append((x, y))

                if (x, y) in points:
                    ii = points.index((x, y))
                    if points_cost[ii] != -1:
                        continue
                    find_cnt += 1
                    points_cost[ii] = cost[x][y]

    return points_cost


def dfs(start, dest, sum, point_cnt, visited_cnt):
    global answer
    global check

    if graph[start][dest] == -1:
        return

    # 다 방문 했으면 최소값 저장하고 종료
    if visited_cnt == point_cnt:
        answer = min(answer, sum)
        return

    # 아직 방문 안한곳이 있으면 재귀로 방문
    for next in range(1, point_cnt+1):
        if not(check[next]) and graph[start][dest] != -1:

            check[next] = True

            if answer >= sum: # 굳이 재귀 들어갈 가치가 없으면(이미 최소값이 아닌걸 안다면) 들어가지 말기
                dfs(dest, next, sum+graph[dest][next], point_cnt, visited_cnt+1)

            check[next] = False


# 메인 함수
while True:
    l = sys.stdin.readline().strip().split()
    w = int(l[0])
    h = int(l[1])
    if w == 0 and h == 0:
        exit(0)

    # 지도 입력받고 시작점, 더러운점 저장
    map = []
    dirty_points = []

    for r in range(h):
        row = sys.stdin.readline().strip()
        for c in range(w):
            if row[c] == '*':
                dirty_points.append((r, c))
            elif row[c] == 'o':
                start = (r, c)
        map.append(row)

    # 시작점, 더러운점들 간 모든 비용을 graph로 저장 (bfs 탐색사용)
    points = [start] + dirty_points
    graph = []
    for idx in range(len(points)):
        graph.append(getCost(map, idx, points))

    # 모든 케이스를 해보며 최소비용을 구하기(외판원 순회 문제와 동일)
    # DFS로 재귀 호출했으나, 다음 순열 구하는 함수로 해도 가능
    global answer
    global check
    answer = 2000000000
    for dest in range(1, len(dirty_points)+1):
        check = [True] + [False] * len(dirty_points)
        dfs(0, dest, graph[0][dest], len(dirty_points), 0)

    if answer == 2000000000:
        print(-1)
    else:
        print(answer)
