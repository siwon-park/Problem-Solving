# 알고리즘 수업 - 깊이 우선 탐색 1(24479번)
##################################################################################
    # 문제: https://www.acmicpc.net/problem/24479
    # DFS
    # 일반적인 DFS문제로 각 노드의 방문 순서를 구하는 문제이다.
    # 각 노드를 오름차순으로 방문해야한다.
    # 이 문제 시리즈를 기억해뒀다가 자바로 연습할 때 풀어도 좋을 것 같다.
##################################################################################
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
    graph[i] = sorted(graph[i])


def dfs(cur):
    global no
    visited[cur] = no
    no += 1
    for nxt in graph[cur]:
        if not visited[nxt]:
            dfs(nxt)

no = 1

dfs(R)

for i in range(1, N + 1):
    print(visited[i])
