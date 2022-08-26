# 서울 지하철 2호선(16947번)
######################################################################################################
    # 문제: https://www.acmicpc.net/problem/16947
    # BFS, DFS
    # 풀이가 비효율적이라고 생각하고 풀었는데, 예상대로 그리 효율적인 풀이는 아니었다.
    # 각 노드별로 DFS를 돌려서 순환선에 해당하면 visited에 True를 체크한다.
    # 그후 각 노드별로 BFS를 돌려서 순환선까지의 최단 거리를 구한다.
    # 효율적인 풀이는 DFS, BFS를 딱 한번씩만 돌리고 있었다. (코드를 보는데 살짝 이해가 안 가서 나중에 이해가 가면 올리겠음)
######################################################################################################
import sys
from collections import deque
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

N = int(input())
graph = [[] for _ in range(N + 1)]

distance = [0] * (N + 1)
visited = [False] * (N + 1) # 순환선이면 True

for _ in range(N):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

def dfs(start, cur, tmp_visited):
    tmp_visited[cur] = True
    for nxt in graph[cur]:
        if not tmp_visited[nxt]:
            dfs(start, nxt, tmp_visited)
        elif start == cur and tmp_visited[start]: # 순환이면
            return False
    return True

# 순환선 찾기
for i in range(1, N + 1):
    tmp_visited = [False] * (N + 1)
    ret = dfs(i, i, tmp_visited)
    if not ret:
        visited[i] = True # 순환선 표시

def bfs(q, start):
    while q:
        d, cur = q.popleft()
        if visited[cur]:
            distance[start] = d
            return
        for nxt in graph[cur]:
            if not tmp_visited[nxt]:
                tmp_visited[nxt] = True
                q.append((d + 1, nxt))

# 순환선까지 최단 거리 찾기
for i in range(1, N + 1):
    tmp_visited = [False] * (N + 1)
    q = deque([(0, i)])
    tmp_visited[i] = True
    bfs(q, i)

print(*distance[1:])
