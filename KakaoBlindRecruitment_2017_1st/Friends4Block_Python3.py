# -*- coding: utf-8 -*-
# https://www.welcomekakao.com/learn/courses/30/lessons/17679?language=python3


def solution(m, n, board):
    answer = 0

    while True:
        # 4블록 스캔해서 지워질 좌표 찾기
        s = set()
        for i in range(m-1):
            for j in range(n-1):
                c = board[i][j]
                if c == ' ':
                    continue

                if c == board[i][j+1] and c == board[i+1][j] and c == board[i+1][j+1]:
                    s.add((i,j))
                    s.add((i+1,j))
                    s.add((i,j+1))
                    s.add((i+1,j+1))

        # 탈출 조건
        if len(s) == 0:
            return answer
        else:
            answer += len(s)

        # 위에꺼 끌어내리기
        li = list(s)
        li = sorted(li)#, key=lambda tup: tup[0])

        for i,j in li:
            if i==0:
                # board[i][j] = ' '

                board[0] = board[0][0:j] + ' ' + board[0][j+1:]

            else:
                while True:
                    # 위에꺼 끌어 내리기
                    # board[i][j] = board[i-1][j]
                    # board[i-1][j] = ' '
                    board[i] = board[i][0:j] + board[i-1][j] + board[i][j+1:]
                    board[i-1] = board[i-1][0:j] + ' ' + board[i-1][j+1:]

                    # 탈출 조건
                    if i == 1 or board[i-2][j] == ' ':
                        break
                    i -= 1



board = ["CCBDE", "AAADE", "AAABF", "CCBBF"]
print(solution(4, 5, board))