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


N, M = map(int, input().split())
edges = []
max_cost = 0
for i in range(M):
    a, b, c = map(int, input().split())
    edges.append((c, a, b))
    max_cost += c

edges.sort()
parent = [i for i in range(N + 1)]
result = 0
for edge in edges:
    cost, a, b = edge
    if find_parent(parent, a) != find_parent(parent, b):
        union_parent(parent, a, b)
        result += cost


def check():
    for i in range(1, N + 1):
        find_parent(parent, i)
        if parent[i] != 1:
            return -1
    return max_cost - result        


print(check())
