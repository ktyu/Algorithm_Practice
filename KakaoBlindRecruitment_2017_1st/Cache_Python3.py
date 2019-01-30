# -*- coding: utf-8 -*-
# https://www.welcomekakao.com/learn/courses/30/lessons/17680?language=python3

def solution(cacheSize, cities):
    answer = 0
    cache = []
    
    if cacheSize==0:
        return len(cities)*5
    
    for c in cities:
        city = c.lower()
        cache = cache[cacheSize*(-1):]
        if city in cache:
            answer += 1
            cache.remove(city)
            cache.append(city)
        else:
            answer += 5
            cache.append(city)
    
    return answer
