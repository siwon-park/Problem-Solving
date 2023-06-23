import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

N = int(input())
graph = [[] for _ in range(N + 1)]
for _ in range(N - 1):
    f, t, l = map(int, input().split())
    graph[f].append((t, l))
    graph[t].append((f, l))

# 1번 노드에서 가장 멀리 떨어져 있는 노드(fn)를 구함
# fn에서 다른 노드까지의 거리 테이블을 구함 D1
# D1에서 가장 먼 노드에서 다른 노드까지의 거리 테이블을 구함 D2
# D1과 D2의 max값을 비교
D1 = [0] * (N + 1)
D2 = [0] * (N + 1)

def dfs(cur, d, D):
    global fn, fd
    if d > fd:
        fd = d
        fn = cur
    D[cur] = d
    visited[cur] = True
    for nxt, l in graph[cur]:
        if not visited[nxt]:
            dfs(nxt, d + l, D)

visited = [False] * (N + 1)
fn = 0
fd = 0 # 가장 먼 거리
dfs(1, 0, D1)

visited = [False] * (N + 1)
D1 = [0] * (N + 1)
dfs(fn, 0, D1)

visited = [False] * (N + 1)
dfs(fn, 0, D2)

for i in range(1, N + 1):
    print(max(D1[i], D2[i]))