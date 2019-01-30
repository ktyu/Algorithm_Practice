# -*- coding: utf-8 -*-

nums = []
for i in range(9):
    nums.append(int(input()))

sum = sum(nums)

for i in range(9):
    for j in range(i+1, 9):
        a = nums[i]
        b = nums[j]
        if 100 == sum-(a+b):
            aa = a
            bb = b

nums.remove(aa)
nums.remove(bb)
nums.sort()
for num in nums:
    print(num)
