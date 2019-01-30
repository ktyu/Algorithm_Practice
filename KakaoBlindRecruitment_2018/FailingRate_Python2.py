# -*- coding: utf-8 -*-
# https://www.welcomekakao.com/learn/courses/30/lessons/42889?language=python

def solution(N, stages):

    fail_count = [0] * (N+2)
    try_count = [0] * (N+2)

    for num in stages:
        fail_count[num] += 1

        for n in range(1, num+1):
            try_count[n] += 1

    fail_count = fail_count[1:-1]
    try_count = try_count[1:-1]

    rate = []
    for i in range(N):
        if try_count[i] == 0:
            tu = (0, N-i)
        else:
            tu = (fail_count[i]*1.0 / try_count[i], N-i)
            
        rate.append(tu)

    rate = sorted(rate, reverse=True)

    answer = []
    for tu in rate:
        answer.append(N-tu[1]+1)

    return answer