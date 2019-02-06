def next_permutation(permu):

    i = len(permu) - 1
    while i > 0 and permu[i-1] >= permu[i]:
        i -= 1

    if i == 0:
        return False

    j = i
    while j+1 < len(permu) and permu[i-1] <= permu[j+1]:
        j += 1

    permu[i-1], permu[j] = permu[j], permu[i-1]

    k = len(permu) -1
    while i<k:
        permu[i], permu[k] = permu[k], permu[i]
        i += 1
        k -= 1
    return permu


arr = []
n = int(input().strip())

for i in range(n):
    arr.append(list(map(int, input().strip().split())))

permu = list(range(1,n))
cost = 9999999999999

while permu != False:
    permu = [0] + permu + [0]

    new_cost = 0
    for i in range(n):
        way = arr[permu[i]][permu[i+1]]
        if way == 0:
            new_cost = 9999999999999
            break
        else:
            new_cost += arr[permu[i]][permu[i+1]]

    if(new_cost < cost):
        cost = new_cost

    permu = next_permutation(permu[1:-1])

print(cost)
