# 너구리 구구(18126번)
############################################################################
    # 문제: https://www.acmicpc.net/problem/18126
    # DFS
    # 그냥 일반적인 거리 누적 DFS, BFS 탐색 문제였다.
    # 정답률이 30%대라서 뭔가 신경써야할 게 있나 싶었는데, 없었다. 괜히 쫄았다...
############################################################################
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

N = int(input())
graph = [[] for _ in range(N + 1)]
for _ in range(N - 1):
    A, B, C = map(int, input().split())
    graph[A].append((B, C))
    graph[B].append((A, C))

visited = [-1] * (N + 1)

def dfs(cur, d):
    visited[cur] = d
    for nxt, nxt_d in graph[cur]:
        if visited[nxt] == -1:
            dfs(nxt, d + nxt_d)

dfs(1, 0)
print(max(visited))
