# 효율적인 해킹(1325번)
##############################################################
    # 문제: https://www.acmicpc.net/problem/1325
    # BFS, DFS
    # 여러모로 아쉬움이 많이 남는 문제다. 분명히 효율적으로 풀 수 있을 것 같은데 모든 정점에 대해 BFS를 돌리는 방식으로 풀었다
    # DFS와 메모이제이션으로 접근해봤는데, 사이클이 아닐 때는 괜찮았으나 사이클일 경우 재귀호출 제한 초과 또는 답이 제대로 안 나와서 포기했다.
    # 이미 방문한 정점이면 더 이상 탐색하지 못하게 하도록 짜고 싶었는데 실력이 부족해서 여러모로 고민만 하다 시간만 많이 썼다.
    # BFS로 풀었지만 체크해뒀다가 DFS로도 풀어봐야겠다.
    # DFS로 시도하고 있었는데, 리턴값이 의도하는 대로 반환이 안돼서 포기하고 BFS로 풀었다.
    # Python3는 1%에서 시간초과이고, Pypy3로 9000ms대로 통과할 수 있었다.
##############################################################
import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())
graph = [[] for _ in range(N+1)]
for _ in range(M):
    A, B = map(int, input().split())
    graph[B].append(A)

def bfs(s):
    visited = [False] * (N+1)
    visited[s] = True
    cnt = 1
    q = deque([s])
    while q:
        cur = q.popleft()
        for nxt in graph[cur]:
            if not visited[nxt]:
                visited[nxt] = True
                q.append(nxt)
                cnt += 1
    return cnt

max_h = 0
for i in range(1, N+1):
    h = bfs(i)
    if h > max_h:
        ret = [i]
        max_h = h
    elif h == max_h:
        ret.append(i)
        
print(*ret)
