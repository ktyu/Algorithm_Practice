import sys

n, k = map(int, sys.stdin.readline().strip().split())
if n==k:
    print(0)
    exit(0)

deque = []

cost = [-1]*100001
cost[n] = 0
deque.append(n)


while len(deque) != 0:

    current_position = deque.pop(0)

    if 2*current_position < 100001 and cost[2*current_position] == -1:
        cost[2*current_position] = cost[current_position]
        deque.insert(0, 2*current_position)

        if(2*current_position) == k:
            print(cost[2*current_position])
            break

    if current_position+1 < 100001 and cost[current_position+1] == -1:
        cost[current_position+1] = cost[current_position] + 1
        deque.append(current_position+1)

        if(current_position+1) == k:
            print(cost[current_position+1])
            break

    if current_position-1 >= 0 and cost[current_position-1] == -1:
        cost[current_position-1] = cost[current_position] + 1
        deque.append(current_position-1)

        if(current_position-1) == k:
            print(cost[current_position-1])
            break
