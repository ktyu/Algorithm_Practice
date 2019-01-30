# -*- coding: utf-8 -*-
# https://www.welcomekakao.com/learn/courses/30/lessons/17677?language=python3

import copy

def solution(str1, str2):
    str1_list = []
    str2_list = []

    for i in range(len(str1)-1):
        part = str1[i:i+2]
        if part.isalpha():
            str1_list.append(part.lower()) # 무조건 소문자로 저장

    for i in range(len(str2)-1):
        part = str2[i:i+2]
        if part.isalpha():
            str2_list.append(part.lower()) # 무조건 소문자로 저장
            
    print (str1_list)
    print (str2_list)
            
    if len(str1_list) + len(str2_list) == 0:
        return 65536
            
    hap = copy.deepcopy(str1_list)
    kyo = []
    
    for part in str2_list:
        if part in hap: # str2 조각이 -> str1_list + 직전까지 본 str2 조각들의 합집합에 있으면
            if kyo.count(part) < str1_list.count(part) and kyo.count(part) < str2_list.count(part):
                kyo.append(part)
            
            # 합집합엔 max로
            if hap.count(part) < str2_list.count(part):
                hap.append(part)
            
        else: # str2 조각이 str1에 없으면
            hap.append(part)
    
    print (kyo)
    print (hap)
    return int((len(kyo) / len(hap))*65536)
