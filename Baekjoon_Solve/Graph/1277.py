# 발전소 설치(1277번)
#######################################################################################
    # 문제: https://www.acmicpc.net/problem/1277
    # 그래프 이론, BFS
    # 서로 연결되어 있는 W개의 노드에 대해서는 그래프에 해당 노드간 거리를 0으로 설정한다
    # 나머지 노드에 대해서는 각자 노드까지의 거리를 계산해서 그래프에 넣는다(O(N^2))
    # 그리고 1부터 N까지의 최단 거리를 구해서 1000을 곱한 다음 int형으로 변환하면 내림이 되므로 그렇게 출력하면 된다.
#######################################################################################
import sys
from collections import deque
input = sys.stdin.readline

def cal_dist(x1, y1, x2, y2):
    return ((x1 - x2)**2 + (y1 - y2)**2) ** (1/2)

N, W = map(int, input().split())
M = float(input())

lst = []
for i in range(N):
    x, y = map(int, input().split())
    lst.append((i + 1, x, y))

graph = [[] for _ in range(N + 1)]
for _ in range(W): # 연결되어 있음
    a, b = map(int, input().split())
    graph[a].append((b, 0))
    graph[b].append((a, 0))

for i in range(N - 1):
    n1, x1, y1 = lst[i]
    for j in range(i + 1, N):
        n2, x2, y2 = lst[j]
        d = cal_dist(x1, y1, x2, y2)
        graph[n1].append((n2, d))
        graph[n2].append((n1, d))

def bfs():
    INF = int(1e9)
    visitied = [INF] * (N + 1)
    visitied[1] = 0
    q = deque([(0, 1)])
    while q:
        cur_d, cur = q.popleft()
        for nxt, nxt_d in graph[cur]:
            d = cur_d + nxt_d
            if d < visitied[nxt] and nxt_d <= M:
                visitied[nxt] = d
                q.append((d, nxt))

    return visitied[N]

dist = bfs()
print(int(dist * 1000))
