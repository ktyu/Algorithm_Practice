import sys

def recursive(now, visited):

    if now in visited:
        return

    if len(visited) == 4:
        print(1)
        exit(0)

    for next in nodes[now]:
        recursive(next, visited + [now])


n, m = list(map(int, sys.stdin.readline().strip().split()))
nodes = []
for _ in range(n):
    nodes.append([])

for _ in range(m):
    a, b = list(map(int, sys.stdin.readline().strip().split()))
    nodes[a].append(b)
    nodes[b].append(a)

for start in range(n):
    recursive(start, [])
print(0)
