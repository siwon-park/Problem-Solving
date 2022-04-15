# 정점들의 거리(1761번)
#########################################################################
    # 문제: https://www.acmicpc.net/problem/1761
    # 트리, 최소 공통 조상(LCA)
    # Python3 9% 시간초과, Pypy3 1004ms 통과
    # 아마 좀 더 최적화된 LCA 알고리즘을 적용하면 Python3로도 통과할 것이라고 생각한다.
    # 최소 공통 조상을 구하는 알고리즘을 적용한 뒤에, a와 b를 입력 받았을 때 둘 중 하나가 둘의 최소 공통 조상이면
    # if문 분기를 두어서 구별을 하여 계산하고, 그게 아니라면 (루트에서 a까지의 거리) + (루트에서 b까지의 거리) - 2*(a,b의 LCA까지의 거리)이다.
    # 2를 곱해주는 이유는 루트에서 a까지 가는데 최소 공통 조상을 1번 지나고, 루트에서 b까지 가는데 최소 공통 조상을 1번 더 지나기 때문이다.
#########################################################################
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

def dfs(cur, d, cost):
    visited[cur] = True
    dist[cur] = cost
    depth[cur] = d
    for nxt, c in graph[cur]:
        if not visited[nxt]:
            parent[nxt] = cur
            dfs(nxt, d+1, cost + c)

def lca(a, b):
    while depth[a] != depth[b]:
        if depth[a] < depth[b]:
            b = parent[b]
        else:
            a = parent[a]
    while a != b:
        a = parent[a]
        b = parent[b]
    return a

N = int(input())
graph = [[] for _ in range(N+1)]
depth = [0] * (N+1)
parent = [i for i in range(N+1)]
visited = [False] * (N+1)
dist = [0] * (N+1)
for _ in range(N-1):
    A, B, C = map(int, input().split())
    graph[A].append((B, C))
    graph[B].append((A, C))

dfs(1, 0, 0)

for _ in range(int(input())):
    a, b = map(int, input().split())
    anc = lca(a, b) # 최소 공통 조상에 따라 분기를 달리해서 거리를 계산한다.
    if a == anc:
        d = dist[b] - dist[anc]
    elif b == anc:
        d = dist[a] - dist[anc]
    else:
        d = dist[a] + dist[b] - 2 * dist[anc]
    print(d)
