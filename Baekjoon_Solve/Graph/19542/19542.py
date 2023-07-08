# 전단지 돌리기 (19542번)
import sys
sys.setrecursionlimit(int(1e6))
input = sys.stdin.readline

N, S, D = map(int, input().rstrip().split())
graph = [[] for _ in range(N + 1)]
for _ in range(N - 1):
    a, b = map(int, input().rstrip().split())
    graph[a].append(b)
    graph[b].append(a)

distance = [0] * (N + 1)


# 각 노드별로 가장 먼 거리에 있는 노드까지의 거리를 기록하는 dfs
def dfs(cur: int) -> int:
    dist = 0
    for nxt in graph[cur]:
        if not visited[nxt]:
            visited[nxt] = True
            dist = max(dist, dfs(nxt) + 1)
    distance[cur] = dist
    return distance[cur]


# 전단지를 다 돌리고 오는데 드는 거리를 구하는 dfs
def distribute(cur: int) -> None:
    global ans
    for nxt in graph[cur]:
        if not visited[nxt] and distance[nxt] >= D:  # D 이상으로 드는 곳은 방문해야 함
            visited[nxt] = True
            ans += 1
            distribute(nxt)


visited = [False] * (N + 1)
visited[S] = True
dfs(S)
visited = [False] * (N + 1)
visited[S] = True
ans = 0
distribute(S)
print(ans * 2)