# 트리의 지름(1967번)
###################################################################
    # 문제: https://www.acmicpc.net/problem/1967
    # 트리, DFS
    # 처음에 LCA 알고리즘을 응용해서 각 노드간 2개의 조합을 선택한 뒤 가장 먼 거리를 구하려고 하였으나
    # N의 개수가 최대 1만개이므로, 시간 초과가 날 것이라고 판단했다.
    # 왜냐하면 1만개 중 2개를 고르는 조합 x lca알고리즘이 동작하는 시간을 계산하면 충분히 시간 초과가 날 것이다.
    # 그래서 고민하던 도중 힌트를 얻어서 쉽게 해결할 수 있었다.
    # 아무 노드에서 출발하여 해당 노드에서 가장 먼 거리에 있는 노드 및 거리를 구한다.
    # 구한 노드에서 다시 동일하게 가장 먼 거리에 있는 노드 및 거리를 구하면 그게 바로 트리의 지름이다.
###################################################################
import sys
sys.setrecursionlimit(int(1e6))
input = sys.stdin.readline

n = int(input())
graph = [[] for _ in range(n+1)]

for i in range(n-1):
    p, c, d = map(int, input().split())
    graph[p].append((c, d))
    graph[c].append((p, d))

depth = [0]*(n+1)
visited = [False]*(n+1)

dist = 0
far_node = 1

def dfs(cur, d):
    global dist, far_node
    visited[cur] = True
    depth[cur] = d
    if d > dist: # 최장 거리와 가장 먼 노드 갱신
        dist = d
        far_node = cur
    for nxt, dst in graph[cur]:
        if not visited[nxt]:
            dfs(nxt, d+dst)

dfs(1, 0) # 출발 노드, 거리(출발 노드에서 출발 노드까지는 항상 0이므로 0)
visited = [False]*(n+1) # 트리 재탐색을 위한 방문 초기화
dfs(far_node, 0) # 처음으로 구한 가장 먼 노드에서 출발해서 가장 먼 노드까지의 거리 계산 
print(dist)
