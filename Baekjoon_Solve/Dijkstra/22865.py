# 가장 먼 곳 (22865번)
###################################################################################################################
    # 문제: https://www.acmicpc.net/problem/22865
    # 다익스트라
    # A, B, C의 좌표를 출발점으로하여 모든 좌표에 대한 각각의 최단 거리 테이블을 구한 다음에
    # 역순으로 탐색해서 문제에서 요구하는 좌표의 번호(인덱스)를 찾는다.
    # 역순으로 찾는 이유는 가장 먼 거리가 여러 개일 경우, 가장 낮은 인덱스를 찾아야하므로 그렇다.
    # 처음에 해당 풀이로 시간초과가 날 줄 알았는데, 통과할 수 있었다.
    # 사실 다른 방법을 생각해보려고 했는데 딱히 떠오르지 않아서 본 풀이법으로 풀었다.
###################################################################################################################
import sys, heapq
input = sys.stdin.readline


def dijkstra(s):
    INF = sys.maxsize
    distance = [INF] * (N + 1)
    distance[s] = 0
    pq = []
    heapq.heappush(pq, (0, s))
    while pq:
        d, cur = heapq.heappop(pq)
        if distance[cur] < d:
            continue
        for nxt, l in graph[cur]:
            cost = d + l
            if cost < distance[nxt]:
                distance[nxt] = cost
                heapq.heappush(pq, (cost, nxt))
    return distance


N = int(input())
A, B, C = map(int, input().split())
M = int(input())
graph = [[] for _ in range(N + 1)]
for _ in range(M):
    D, E, L = map(int, input().split())
    graph[D].append((E, L))
    graph[E].append((D, L))

da = dijkstra(A)
db = dijkstra(B)
dc = dijkstra(C)

ans = -sys.maxsize
idx = 0
for i in range(N, 0, -1):
    dst = min(da[i], db[i], dc[i])
    if dst >= ans:
        ans = dst
        idx = i
print(idx)
