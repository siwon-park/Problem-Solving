# 알고리즘 수업 - 너비 우선 탐색 1(24444번)
########################################################################
    # 문제: https://www.acmicpc.net/problem/24444
    # BFS
    # N의 최대가 10만이고, 작은 숫자의 노드를 먼저 방문해야하므로 각 노드의 연결 간선을 정렬해줘야한다.
    # 일단 생각나는 방법 그대로 풀어보자해서 풀어보았는데, 내 생각? 보다는 많이 걸리진 않았다.
    # 그외에는 아주 평범한 BFS문제이다.
########################################################################
import sys
from collections import deque
input = sys.stdin.readline

N, M, R = map(int, input().split())

graph = [[] for _ in range(N + 1)]
for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(1, N + 1):
    graph[i] = sorted(graph[i])

def bfs(R):
    q = deque([R])
    visited = [0] * (N + 1)
    order = 1
    visited[R] = order
    order += 1
    while q:
        cur = q.popleft()
        for nxt in graph[cur]:
            if not visited[nxt]:
                q.append(nxt)
                visited[nxt] = order
                order += 1
    return visited

v = bfs(R)

for i in range(1, N + 1):
    print(v[i])
