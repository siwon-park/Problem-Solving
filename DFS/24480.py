# 알고리즘 수업 - 깊이 우선 탐색 2(24480번)
############################################################################
    # 문제: https://www.acmicpc.net/problem/24480
    # DFS
    # 평범한 DFS탐색 문제이다.
    # 인접 정점을 내림차순으로 방문해야한다는 조건을 지켜야한다.
    # 이런 문제를 풀면서 느낀건데 그래프의 i번 리스트에 대해 매번 정렬을 해주는 방법으로 구현했는데
    # 그냥 N개에 대해 모두 정렬해주는 것보다 더 빠르게 하는 방법이 없을까라는 생각을 해본다...(그냥 정렬해주는게 제일 빠른가?)
############################################################################
import sys
sys.setrecursionlimit(int(1e6))
input = sys.stdin.readline

N, M, R = map(int, input().split())
visited = [0] * (N + 1)
graph = [[] for _ in range(N + 1)]
for _ in range(M):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

for i in range(1, N + 1):
    graph[i] = sorted(graph[i], reverse=True)

no = 1
def dfs(cur):
    global no
    visited[cur] = no
    no += 1
    for nxt in graph[cur]:
        if not visited[nxt]:
            dfs(nxt)

dfs(R)
for i in range(1, N + 1):
    print(visited[i])
