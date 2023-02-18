# 보석 줍기(2001번)
#########################################################################
    # 문제: https://www.acmicpc.net/problem/2001
    # BFS, 비트마스킹
    # 비트마스킹을 이용해서 보석을 주웠는지 확인하면서 BFS 탐색을 하면 된다.
    # 현재 주운 보석의 개수가 해당 섬을 지나갈 수 있는 보석 수 제한 이하여야만 한다.
    # 또한 현재 맨 처음 출발할 때 보석의 수는 0이고, 보석이 있는 섬에서 보석을 줍지 않고 이동할 수도 있으므로
    # 방문 배열을 -1로 초기화해야한다.
#########################################################################
import sys
from collections import deque
input = sys.stdin.readline

n, m, K = map(int, input().split())
j_isl = [0] * (n + 1)
k = 1
for _ in range(K):
    j_isl[int(input())] = k
    k += 1

graph = [[] for _ in range(n + 1)]
for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))
    graph[b].append((a, c))

visited = [[-1] * (1 << (K + 1)) for _ in range(n + 1)]

def bfs():
    q = deque([(0, 0, 1)]) # 비트, 보석 수, 섬 위치
    while q:
        k, cnt, cur = q.popleft()
        for nxt, lmt in graph[cur]:
            if cnt <= lmt:
                if j_isl[nxt]:
                    num = j_isl[nxt]
                    if not k & (1 << num): # 해당 보석을 아직 줍지 않았으면
                        new_k = k | (1 << num)
                        if visited[nxt][new_k] < cnt + 1:
                            q.append((new_k, cnt + 1, nxt))
                            visited[nxt][new_k] = cnt + 1
                if visited[nxt][k] < cnt: # 그냥 지나감
                    q.append((k, cnt, nxt))
                    visited[nxt][k] = cnt

    print(max(visited[1]))

bfs()
