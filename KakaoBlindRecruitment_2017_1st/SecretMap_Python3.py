# -*- coding: utf-8 -*-
# https://programmers.co.kr/learn/courses/30/lessons/17681?language=python3

def solution(n, arr1, arr2):
    answer = []
    
    for i in range(n):
        row = bin(arr1[i] | arr2[i])[2:]
        row = '0'*(n-len(row)) + row
        row = row.replace('1', '#')
        row = row.replace('0', ' ')
        answer.append(row)
        
    return answer