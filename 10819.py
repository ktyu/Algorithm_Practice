import copy

# input
n = int(input().strip())
arr = list(map(int, input().strip().split()))
arr.sort()
new_arr = []


### POINT - only two numbers (on edges) will be used once, and the others will be used twice.


# arr size is even num - (only 1 time used are smallest one in maxs and smallest one in mins)
if len(arr) % 2 == 0:
    max_to_left = True

    while(len(arr) > 0):

        if max_to_left:
            max_to_left = False
            new_arr.insert(0, arr.pop()) # biggest
            if(len(arr) == 0):
                break
            new_arr.append(arr.pop(0)) # smallest
            
        else:
            max_to_left = True
            new_arr.append(arr.pop()) # biggest
            if(len(arr) == 0):
                break
            new_arr.insert(0,arr.pop(0)) # smallest
        
        
        
    answer = 0
    for i in range(len(new_arr)-1):
        answer += abs(new_arr[i] - new_arr[i+1])
        

# arr size is odd num - divide to 2 cases
else:
    # backup
    arr_copy = copy.deepcopy(arr)
    
    # case 1 : biggest max is center (only 1 time used are two of biggest ones in min)
    new_arr.append(arr.pop()) # biggest
    new_arr.insert(0,arr.pop(0)) # 2 of smallest
    new_arr.append(arr.pop(0))
    
    turn_to_max = True
    while(len(arr) > 0):
        if turn_to_max:
            turn_to_max = False
            new_arr.insert(0,arr.pop()) # 2 of biggest
            new_arr.append(arr.pop())
            
        else:
            turn_to_max = True
            new_arr.insert(0,arr.pop(0)) # 2 of smallest
            new_arr.append(arr.pop(0))
    
    sum1 = 0
    for i in range(len(new_arr)-1):
        sum1 += abs(new_arr[i] - new_arr[i+1])
        
    # reset
    new_arr = []
    arr = copy.deepcopy(arr_copy)
    
    # case 2 : smallest min is center (only 1 time used are two of smallest ones in max)
    new_arr.append(arr.pop(0)) # smallest
    new_arr.insert(0,arr.pop()) # 2 of biggest
    new_arr.append(arr.pop())
    
    turn_to_max = False
    while(len(arr) > 0):
        if turn_to_max:
            turn_to_max = False
            new_arr.insert(0,arr.pop()) # 2 of biggest
            new_arr.append(arr.pop())
            
        else:
            turn_to_max = True
            new_arr.insert(0,arr.pop(0)) # 2 of smallest
            new_arr.append(arr.pop(0))
        
    sum2 = 0
    for i in range(len(new_arr)-1):
        sum2 += abs(new_arr[i] - new_arr[i+1])
    
    
    # choose better case
    answer = sum1 if sum1>sum2 else sum2
    
print(answer)