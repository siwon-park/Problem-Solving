# 내 왼손에는 흑염룡이 잠들어 있다(13016번)
########################################################################################
    # 문제: https://www.acmicpc.net/problem/13016
    # 트리, DFS
    # 트리의 지름과 관련된 문제
    # 첫 시도는 Python, Pypy 전부 예상한대로 시간초과 판정을 받았다.
    # 어떻게 하면 효율성을 개선할 수 있을까 고민하다가 문득 트리의 지름을 구하는 방법에 대해 활용해보자라는 생각이 들어서 적용시켰더니
    # 매번 DFS를 돌릴 필요 없이 3번만 돌리면 끝이었다.
    # 그런데 그렇게 구현했어도 틀렸다는 판정을 받았는데, 그 이유는 fd(가장 먼 거리)를 활용하지 않고 거리 테이블을 기준으로 가장 먼 노드를 갱신하니까
    # 입력으로 가장 먼 거리를 가진 노드부터 내림차순으로 주어졌을 때, 가장 먼 노드의 갱신이 잘못 되어버리는 케이스가 있어서 fd를 활용해서 갱신하니까 해결할 수 있었다.
########################################################################################
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
# fn번 노드에서 에서 다른 노드까지의 거리 테이블 D1을 구하고 fn과 가장 멀리 떨어진 노드를 구함
# fn과 가장 먼 노드에서 다른 노드까지의 거리 테이블 D2를 구함
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
