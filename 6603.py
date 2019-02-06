def recursive(nums, i, numStr):

    if len(numStr.strip().split()) == 6:
        print(numStr)
        return

    elif i == len(nums):
        return

    else:
        recursive(nums, i+1, numStr + str(nums[i]) + " ")
        recursive(nums, i+1, numStr)


while True:
    arr = list(map(int, input().strip().split()))
    if arr[0] == 0:
        break

    nums = arr[1:]
    recursive(nums, 0, "")
    print('')
