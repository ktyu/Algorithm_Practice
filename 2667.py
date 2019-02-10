# -*- coding: utf-8 -*-

# 2/7 작성 (파이썬)

dx = [0,0,1,-1]
dy = [1,-1,0,0]


def bfs(x, y, gnum):
    queue = []
    cnt = 0
    queue.append((x,y))

    while len(queue) != 0:
        x,y = queue.pop(0)
        if apts[x][y] != '1':
            continue

        apts[x][y] = str(gnum)
        cnt += 1

        # 상하좌우중 아파트가 있는 곳 큐에 넣기
        for i in range(4):
            if 0 <= x+dx[i] < n and 0 <= y+dy[i] < n and apts[x+dx[i]][y+dy[i]] == '1':
                queue.append((x+dx[i], y+dy[i]))

    return cnt


# 입력 받기
n = int(input())
apts = [] # 전역변수
for i in range(n):
    apts.append(list(input()))

groupNum = 2 # 전역변수, 단지번호는 2번부터 시작 (0=아파트없음, 1=아파트있으나 아직 단지구분x, 2~=단지번호)
groupsCnt = [] # 전역변수

# 단지 시작점을 알 수 없기때문에 n*n 로 순회할수밖에 없음
for i in range(n):
    for j in range(n):
        if apts[i][j] == '1': # 단지 구분이안된 아파트 찾으면
            groupsCnt.append(bfs(i, j, groupNum)) # 단지 그룹화해서 개수 저장
            groupNum += 1

# 결과 출력
print(len(groupsCnt))
groupsCnt.sort()
for cnt in groupsCnt:
    print(cnt)
