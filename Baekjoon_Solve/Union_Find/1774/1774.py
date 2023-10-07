import sys
input = sys.stdin.readline


def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]


def union_parent(parent, a, b):
    a, b = find_parent(parent, a), find_parent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b


def distance(x1, y1, x2, y2):
    dist = (x1 - x2) ** 2 + (y1 - y2) ** 2
    return dist ** (1 / 2)


N, M = map(int, input().split())
parent = [i for i in range(N + 1)]
edges, dots = [], []
result = 0

for i in range(N):
    x, y = map(int, input().split())
    dots.append((x, y))
for i in range(N):
    for j in range(i + 1, N):
        a, b, c = i + 1, j + 1, distance(dots[i][0], dots[i][1], dots[j][0], dots[j][1])
        edges.append((c, a, b))

edges.sort()
for i in range(M):
    a, b = map(int, input().split())
    union_parent(parent, a, b)
for edge in edges:
    cost, a, b = edge
    if find_parent(parent, a) != find_parent(parent, b):
        union_parent(parent, a, b)
        result += cost

print(format(round(result, 3), ".2f"))
