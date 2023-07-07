import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

n = int(input())
graph = [[] for _ in range(n+1)]

for i in range(n-1):
    p, c, d = map(int, input().split())
    graph[p].append((c, d))
    graph[c].append((p, d))

depth = [0]*(n+1)
visited = [False]*(n+1)

dist = 0
far_node = 1

def dfs(cur, d):
    global dist, far_node
    visited[cur] = True
    depth[cur] = d
    if d > dist:
        dist = d
        far_node = cur
    for nxt, dst in graph[cur]:
        if not visited[nxt]:
            dfs(nxt, d+dst)

dfs(1, 0)
visited = [False]*(n+1)
dfs(far_node, 0)
print(dist)