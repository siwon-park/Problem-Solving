#물대기(1368번)
import sys
input = sys.stdin.readline


def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]


def union_parent(parent,a,b):
    a, b = find_parent(parent, a), find_parent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b


N = int(input())

edges = []
for i in range(N):
    c = int(input())
    edges.append((c, 0, i + 1))

graph = []
for i in range(N):
    graph.append(list(map(int, input().split())))
    for j in range(i + 1, N):
        edges.append((graph[i][j], i + 1, j + 1))

parent = [i for i in range(N + 1)]
edges.sort()
result = 0
for edge in edges:
    cost, a, b = edge
    if find_parent(parent, a) != find_parent(parent, b):
        union_parent(parent, a, b)
        result += cost
      
print(result)
 
