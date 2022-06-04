# MooTube(Silver) (15591번)
###################################################################################################
    # 문제: https://www.acmicpc.net/problem/15591
    # BFS
    # 처음에는 딕셔너리를 활용해서 N+1크기의 1차원 배열을 각 노드별로 저장한 다음에 모든 노드에 대해 다른 노드까지
    # 최소 유사도를 구해줬으나, Python3로는 시간초과 Pypy3로는 통과할 수 있었다.
    # 보다 빠르게 푼 사람들의 풀이를 보니까 Python3 1등은 union-find로 풀었다.
    # 그리고 보니까 모든 노드에 대해서 BFS를 돌릴 필요도 없었고, 쿼리에 해당하는 v에 대해서만 BFS를 돌려줘도 충분했다
    # 추가적으로 노드별로 최단 거리 테이블을 구하는 것보다, BFS함수에서 유사도가 k이상일 경우에만 BFS 탐색을 계속하게끔 하였다.
    # 왜냐하면 어차피 A에서 B까지 가는 경로는 항상 존재하며 최소 유사도를 그 경로의 거리(?)로 가정하므로
    # 현재 노드에서 직접적으로 바로 연결된 노드까지의 유사도가 k보다 작다는 말은
    # 현재 노드에서 다른 노드까지 이어지는 모든 경로에 있어서 k보다 큰 유사도를 가지는 경로는 없다는 의미이다.
    # 따라서 BFS에서 k 이상일 경우에만 탐색하게끔 하면 된다.
###################################################################################################
import sys
from collections import deque
input = sys.stdin.readline

N, Q = map(int, input().split())
graph = [[] for _ in range(N + 1)]
for _ in range(N - 1):
    p, q, r = map(int, input().split())
    graph[p].append((q, r))
    graph[q].append((p, r))


def bfs(s):
    q = deque([(s)])
    visited[s] = True
    usa_cnt = 0
    while q:
        cur = q.popleft()
        for nxt, usa in graph[cur]:
            if not visited[nxt] and usa >= k:
                visited[nxt] = True
                q.append((nxt))
                usa_cnt += 1
    return usa_cnt

for _ in range(Q):
    k, v = map(int, input().split()) # 유사도가 k 이상이면 v를 보고 있는 소들에게 몇 개의 영상이 추천
    visited = [False] * (N + 1)
    print(bfs(v))
