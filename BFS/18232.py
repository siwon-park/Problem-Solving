# 텔레포트 정거장(18232번)
#######################################################################
    # 문제: https://www.acmicpc.net/problem/18232
    # BFS
    # 숨바꼭질 문제와 거의 같은 문제
    # 다만, 차이가 있다면 연결 그래프를 만들어서 연결된 곳으로만 이동이 가능하다는 특징이 있다.
    # BFS는 첫 방문이면 항상 최단거리를 보장하므로 다음 갈 곳이 범위를 만족하고 not visited[k]일 때만 방문하면 된다. 
#######################################################################
import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())
S, E = map(int, input().split())
graph = [[] for _ in range(N+1)]
for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

def bfs(S, E):
    q = deque([(0, S)])
    visited = [0] * (N + 1)
    visited[S] = -1
    while q:
        d, cur = q.popleft()
        if cur == E:
            return d
        nxt_move = [cur - 1, cur + 1] + graph[cur]
        for nxt in nxt_move:
            if 1 <= nxt <= N and not visited[nxt]:
                visited[nxt] = d + 1
                q.append((d + 1, nxt))

print(bfs(S, E))
