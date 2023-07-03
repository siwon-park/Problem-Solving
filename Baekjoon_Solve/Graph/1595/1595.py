import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

def dfs(cur, d):
    global max_dist, far_node
    if visited[cur] < d:
        return
    visited[cur] = d
    if max_dist < d:
        max_dist = d
        far_node = cur
    for nxt, cost in graph[cur]:
        if d + cost < visited[nxt]:
            dfs(nxt, d + cost)

graph = [[] for _ in range(10001)]
while True:
    try:
        a, b, cost = map(int, input().split())
        graph[a].append((b, cost))
        graph[b].append((a, cost))
    except:
        break

# 어떤 노드에서 가장 먼 거리에 있는 노드를 구함
INF = int(1e9)
visited = [INF] * 10001
far_node = 0
max_dist = 0
dfs(1, 0)

# 가장 먼 거리에 있는 노드에서 가장 멀리 떨어진 노드에 대한 거리를 구함
visited = [INF] * 10001
dfs(far_node, 0)
print(max_dist)