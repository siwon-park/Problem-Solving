# 숨바꼭질(6118번)
#######################################################################
    # 문제: https://www.acmicpc.net/problem/6118
    # BFS
    # 가장 먼 거리에 있는 노드 중 가장 작은 번호를 가진 노드와, 그 거리, 가장 먼 거리에 있는 노드들의 개수를 구하는 문제
    # BFS를 돌려서 최단 거리 테이블을 구한 뒤에 구해야하는 정보들을 구하였다.
#######################################################################
import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())
graph = [[] for _ in range(N + 1)]
for _ in range(M):
    A, B = map(int, input().split())
    graph[A].append(B)
    graph[B].append(A)

def bfs():
    q = deque([1])
    INF = int(1e9)
    visited = [INF] * (N + 1)
    visited[1] = 0
    while q:
        cur = q.popleft()
        for nxt in graph[cur]:
            if visited[nxt] == INF:
                visited[nxt] = visited[cur] + 1
                q.append(nxt)
    return visited

d = bfs()
max_d = 0
cnt = 0
for i in range(1, N+1):
    if d[i] > max_d:
        node = i
        max_d = d[i]
        cnt = 1
    elif d[i] == max_d:
        cnt += 1
    
print(node, max_d, cnt)
