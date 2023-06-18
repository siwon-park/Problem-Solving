import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

def dfs(cur, d, cost):
    visited[cur] = True
    dist[cur] = cost
    depth[cur] = d
    for nxt, c in graph[cur]:
        if not visited[nxt]:
            parent[nxt] = cur
            dfs(nxt, d+1, cost + c)

def lca(a, b):
    while depth[a] != depth[b]:
        if depth[a] < depth[b]:
            b = parent[b]
        else:
            a = parent[a]
    while a != b:
        a = parent[a]
        b = parent[b]
    return a

N = int(input())
graph = [[] for _ in range(N+1)]
depth = [0] * (N+1)
parent = [i for i in range(N+1)]
visited = [False] * (N+1)
dist = [0] * (N+1)
for _ in range(N-1):
    A, B, C = map(int, input().split())
    graph[A].append((B, C))
    graph[B].append((A, C))

dfs(1, 0, 0)

query = []
for _ in range(int(input())):
    a, b = map(int, input().split())
    anc = lca(a, b)
    if a == anc:
        d = dist[b] - dist[anc]
    elif b == anc:
        d = dist[a] - dist[anc]
    else:
        d = dist[a] + dist[b] - 2*dist[anc]
    print(d)