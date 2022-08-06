# 노드 사이의 거리(1240번)
##################################################
    # 문제: https://www.acmicpc.net/problem/1240
    # DFS, BFS, 그래프이론
    # 트리 문제군에 속해서 DFS로 풀이하였음
    # 왜 골드 5인지는 모르겠지만, 평범한 경로 탐색 문제와 같음
    # 404m/s가 나와서 최적화가 가능할 것 같아서 다른 사람들의 풀이를 참고해보니, 가장 빠른 시간 대의 최적화는 LCA를 이용하는 것이었고,
    # 그나마 확인할 수 있는 두 번째 200m/s의 시간대는 dfs를 통해서 목표지점까지 도착해서 원하는 거리를 찾고나서 바로 빠져나오는 것이었음
##################################################
import sys
input = sys.stdin.readline

def dfs(cur, t, dist):
    visited[cur] = True
    if cur == t:
        global node_dist
        node_dist = dist
        return
    for nxt, d in tree[cur]:
        if not visited[nxt]:
            dfs(nxt, t, dist+d)

N, M = map(int, input().split())
E = N-1
tree = [[] for _ in range(N+1)]
for i in range(E):
    n1, n2, d = map(int, input().split())
    tree[n1].append((n2, d))
    tree[n2].append((n1, d))

for j in range(M):
    a, b = map(int, input().split())
    visited = [False] * (N+1)
    node_dist = 0
    dfs(a, b, 0)
    print(node_dist)
