# 무엇을 아느냐가 아니라 누구를 아느냐가 문제다(9694번)
##############################################################################################
    # 문제: https://www.acmicpc.net/problem/9694
    # 다익스트라
    # 최단 거리의 경로를 구하는 문제
    # 최단 거리 탐색을 하면서 경로를 기록해서 최단 거리의 경로를 구하면 된다
    # 만약 경로의 맨 끝이 출발점인 0이 아니면 -1을 출력하면 된다.
##############################################################################################
import sys, heapq
input = sys.stdin.readline

def dijkstra(M):
    INF = sys.maxsize
    p = [-1] * M
    path = [M - 1]
    distance = [INF] * M
    distance[0] = 0
    pq = []
    heapq.heappush(pq, (0, 0)) # 친밀도, 노드
    while pq:
        cur_f, cur = heapq.heappop(pq)
        if distance[cur] < cur_f:
            continue
        for nxt, nxt_f in graph[cur]:
            f = nxt_f + cur_f
            if f < distance[nxt]:
                distance[nxt] = f
                heapq.heappush(pq, (f, nxt))
                p[nxt] = cur

    end = M - 1
    while p[end] != -1:
        path.append(p[end])
        end = p[end]
    if path[-1] != 0:
        return [-1]
    return path[::-1]

T = int(input())
for tc in range(T):
    N, M = map(int, input().split())
    graph = [[] for _ in range(M)]
    for _ in range(N):
        x, y, z = map(int, input().split())
        graph[x].append((y, z))
        graph[y].append((x, z))
    r = dijkstra(M)
    print(f'Case #{tc + 1}:', *r)
