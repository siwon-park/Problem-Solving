# 대운하(2350번)
##########################################################################################
    # 문제: https://www.acmicpc.net/problem/2350
    # union-find(분리집합), BFS
    # 최대 스패닝 트리를 구성하고, K개의 노드 관계가 주어졌을 때 BFS탐색을 통해서 해당 노드 간 최소 배의 폭을 구하면 된다.
    # 최대 스패닝 트리를 구성했기 때문에, 노드 a에서 노드 b로 갈 때의 최소 배의 폭이 해당 노드 간 구간의 최대 배의 폭이 되는 것이다.
    # 최대 스패닝 트리를 구성하는 것까진 금방왔는데, 이것을 BFS탐색을 해야하나, 하면 시간초과가 날 것 같은데 고민하는데 시간을 소비했다.
    # K <= 10000, N <= 1000이기 때문에 최악의 경우 O(N*K)여서 시간초과가 발생하지 않았던 것 같다.(시간 복잡도가 이게 맞는지 모르겠다)
##########################################################################################
import sys
from collections import deque
input = sys.stdin.readline

def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def union(a, b):
    a, b = find(a), find(b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

N, M, K = map(int, input().split())

parent = [i for i in range(N + 1)]

edges = []
for _ in range(M):
    i, j, w = map(int, input().split())
    edges.append((w, i, j))

edges.sort(key=lambda x: -x[0])

cnt = 0
graph = [[] for _ in range(N + 1)]
for edge in edges:
    w, a, b = edge
    if find(a) != find(b):
        union(a, b)
        graph[a].append((b, w))
        graph[b].append((a, w))
        cnt += 1
        if cnt == N - 1:
            break

for _ in range(K):
    i, j = map(int, input().split())
    visited = [False] * (N + 1)
    visited[i] = True
    q = deque([(sys.maxsize, i)])
    while q:
        c, cur = q.popleft()
        if cur == j:
            print(c)
            break
        for nxt, cost in graph[cur]:
            if not visited[nxt]:
                visited[nxt] = True
                q.append((min(c, cost), nxt))
