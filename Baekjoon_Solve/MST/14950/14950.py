import sys
input = sys.stdin.readline
N, M, t = map(int, input().split())
edges, result = [], 0
parent = [i for i in range(N + 1)]


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


for i in range(M):
    A, B, C = map(int, input().split())
    edges.append((C, A, B))

edges.sort()
n = 0
for edge in edges:
    cost, a, b = edge
    if find_parent(parent, a) != find_parent(parent, b):
        union_parent(parent, a, b)
        result += cost + t * n
        n += 1

print(result)
