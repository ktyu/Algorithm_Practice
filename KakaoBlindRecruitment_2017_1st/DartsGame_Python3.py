# -*- coding: utf-8 -*-
# https://www.welcomekakao.com/learn/courses/30/lessons/17682?language=python3

def solution(dartResult):
    answer = []
    
    i = 0
    while i < len(dartResult):
        if dartResult[i+1] == '0':
            point = 10
            i += 1
        else:
            point = dartResult[i]
        i += 1
        ###
        power = 0
        power = 1 if dartResult[i] == 'S' else power
        power = 2 if dartResult[i] == 'D' else power
        power = 3 if dartResult[i] == 'T' else power
        point = int(point)**power
        i += 1
        ###
        if i < len(dartResult) and not(dartResult[i].isalnum()):
            if dartResult[i] == '*':
                point *= 2
                if 0 != len(answer):
                    answer[-1] = answer[-1] * 2
            else:
                point *= -1
            i += 1
        ###
        answer.append(point)
    
    return sum(answer)