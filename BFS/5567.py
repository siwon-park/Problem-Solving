# 결혼식(5567번)
###############################################################
    # 문제: https://www.acmicpc.net/problem/5567
    # BFS, 그래프 이론
    # 친구의 친구까지만 결혼식에 초대하므로, 나와 상대방과의 연결 관계 거리가 2이하인 사람들만 카운트해서 반환하면 된다.
###############################################################
import sys
from collections import deque
input = sys.stdin.readline

def bfs(s):
    INF = sys.maxsize
    visited = [INF]*(n+1)
    visited[s] = 0
    q = deque([s])
    while q:
        cur = q.popleft()
        for nxt in graph[cur]:
            if visited[cur] + 1 < visited[nxt]:
                visited[nxt] = visited[cur] + 1
                q.append(nxt)

    cnt = 0
    for i in range(2, n+1):
        if visited[i] <= 2:
            cnt += 1
    
    return cnt

n = int(input())
m = int(input())
graph = [[] for _ in range(n+1)]

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

print(bfs(1))
