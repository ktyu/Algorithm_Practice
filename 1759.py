def recursive(arr, i, l, password):

    # 정답인 경우
    if len(password) == l:
        vowel = password.count('a') + password.count('e') + password.count('i') + password.count('o') + password.count('u')
        consonant = len(password) - vowel
        if vowel >= 1 and consonant >= 2:
            print(password)
        return

    # 안되는 경우
    elif len(password) >= l:
        return

    # 다음꺼 호출
    if i < len(arr):
        recursive(arr, i+1, l, password+arr[i])  # 다음문자 사용
        recursive(arr, i+1, l, password)  # 다음문자 사용x


l = int(input().strip().split()[0])
arr = input().strip().split()
arr.sort()
recursive(arr, 0, l, "")
