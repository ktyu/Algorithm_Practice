# -*- coding: utf-8 -*-
import copy


# 맨 뒤에 큰 숫자들이 차례로 간다
def bubbleSort(raw_arr):
    arr = copy.deepcopy(raw_arr)
    
    for i in range(len(arr)-1):
        for j in range(len(arr)-1-i):
            if arr[j] > arr[j+1]:
                temp = arr[j]
                arr[j] = arr[j+1]
                arr[j+1] = temp
    
    return arr
    
    
# 정렬 안된 전체 배열 스캔 후 가장 작은걸 맨 왼쪽으로 보냄
def selectionSort(raw_arr):
    arr = copy.deepcopy(raw_arr)
    
    for i in range(len(arr)):
        smallest_idx = i
        for j in range(i, len(arr)):
            if arr[smallest_idx] > arr[j]:
                smallest_idx = j
        temp = arr[i]
        arr[i] = arr[smallest_idx]
        arr[smallest_idx] = temp
    
    return arr
    

    
# 다음 원소를 골라서, 이미 정렬된 왼쪽 배열의 적절한 위치를 찾아 땡기다가 해당 위치를 찾으면 삽입
def insertionSort(raw_arr):
    arr = copy.deepcopy(raw_arr)
    
    for i in range(1, len(arr)):
        picked = arr[i]
        for j in reversed(range(i)):
            if arr[j] > picked:
                arr[j+1] = arr[j]
                arr[j] = picked
            else:
                break
    
    return arr
    
    
# 퀵소트 분할정복 (재귀, 추가 메모리 사용(코드 단순화 목적))
def quickSort(x):
    if len(x) <= 1:
        return x

    pivot = x[len(x) // 2] # // 은 나눗셈의 몫(정수)만 구하는 연산
    less = []
    more = []
    equal = []
    for a in x:
        if a < pivot:
            less.append(a)
        elif a > pivot:
            more.append(a)
        else:
            equal.append(a)

    return quickSort(less) + equal + quickSort(more)

    
# 팩토리알 구하기 (재귀)
def factorial(n):
    if n==0:
        return 1
    elif n==1:
        return 1
    return factorial(n-1)*n


# 피보나치 수열 구하기 (재귀x, 반복문으로)
def fibo(n):
    a=0
    b=1
    for i in range(n):
        a = a+b
        b = a-b
    return a
    
    
raw_arr = [10,9,8,7,4,1,2,3,5,6]
print "Raw :", raw_arr


print "Bubble :", bubbleSort(raw_arr)
print "Selection :", selectionSort(raw_arr)
print "Insertion :", insertionSort(raw_arr)
print "Quick :", quickSort(raw_arr)
print "factorial :", factorial(10)
print "fibo :",fibo(6)
