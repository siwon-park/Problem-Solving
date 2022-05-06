# 어떤 우유의 배달 목록(Easy) (23835번)
###########################################################################################
    # 문제: https://www.acmicpc.net/problem/23835
    # 트리, DFS
    # 처음에 그냥 방문하면서 배달 우유의 개수를 기록하는 D[위치]에 +1씩 해주는 형태로 구현했는데 틀렸습니다 판정을 받았다
    # 생각해보니 시작 지점에서 목표 지점까지의 경로에 있는 노드만 우유를 배달하는 문제인 것 같다는 느낌이 들었다.
    # 그래서 경로 역추적의 개념을 적용하였고, 경로를 역추적하는 방식이니까 오히려 목표 지점에서 출발해서 시작 지점까지 오게 하여
    # 시작 지점에서 부모 테이블을 활용해 경로를 추적하면서 D 테이블에 우유를 +1씩 해주었다. (부모 테이블 역시 역으로 기록함)
    # 마지막으로 목표 지점의 우유 배달 개수는 while 구문을 빠져나와서 처리해주었다.
###########################################################################################
import sys
sys.setrecursionlimit(int(1e6))
input = sys.stdin.readline

def dfs(cur):
    visited[cur] = True
    for nxt in graph[cur]:
        if not visited[nxt]:
            parent[nxt] = cur
            dfs(nxt)

N = int(input())
graph = [[] for _ in range(N + 1)]
for _ in range(N - 1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

D = [0] * (N + 1) # 배달된 우유의 수

Q = int(input())
for _ in range(Q):
    query = list(map(int, input().split()))
    t = query[0]
    if t == 1:
        u, v = query[1], query[2]
        visited = [False] * (N + 1)
        parent = [i for i in range(N + 1)]
        dfs(v) # 목표 지점에서 출발
        d = 1 # 배달 우유의 수
        while parent[u] != v: # 
            u = parent[u]
            D[u] += d
            d += 1
        D[v] += d # 목표 지점의 배달 우유 수 기록(while 구문 상 parent[u]의 다음 위치가 v이면 parent[u] == v이므로 v까지 배달한 우유를 기록하려면 직접해야함)
    else:
        print(D[query[1]])
