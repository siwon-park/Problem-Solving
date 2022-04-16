# 도로포장(1162번)
#####################################################################
    # 문제: https://www.acmicpc.net/problem/1162
    # 다익스트라
    # 2차원의 최단 거리 테이블을 만드는 것이 핵심이다.
    # 처음 시도했을 때, 1차원의 배열도 가능하지 않을까 생각해서 도전해봤는데 틀렸습니다를 받았다.
    # 5 5 1
    # 1 2 10
    # 1 3 20
    # 2 4 5
    # 3 5 100
    # 4 5 200
    # 인 경우, 1에서 5로 갈 수 있는 최단 거리가 15임에도 불구하고 20을 반환한다.
    # 왜냐하면 1차원의 배열이기 때문에, 무조건 현재 시점에서의 최단거리만 기록하게 되므로
    # 대소 비교를 했을 때, 지금까지는 최단 거리가 아니었지만 이제 도로를 포장했을 때 최단 거리가 되는 경우를 고려하지 않게 된다.
    # 따라서 k번 도로를 포장했을 때의 최단 거리를 나타내는 d[k] = [INF] * (N+1)를 담은 2차원의 최단 거리 배열을 선언한다. 
#####################################################################
import sys, heapq
input = sys.stdin.readline

N, M, K = map(int, input().split())
graph = [[] for _ in range(N+1)]
for _ in range(M):
    A, B, C = map(int, input().split())
    graph[A].append((B, C))
    graph[B].append((A, C))

def dijkstra():
    INF = sys.maxsize
    distance = [[INF for j in range(N+1)] for i in range(K+1)] # k번 도로를 포장했을 때의 최단 거리 테이블을 담은 2차원의 최단 거리 테이블
    for i in range(K+1):
        distance[i][1] = 0
    q = []
    heapq.heappush(q, (0, 0, 1)) # 시간, 포장횟수, 위치
    while q:
        t, k, cur = heapq.heappop(q)
        if distance[k][cur] < t:
            continue
        for nxt, cost in graph[cur]:
            nxt_t = t + cost
            if nxt_t < distance[k][nxt]:
                distance[k][nxt] = nxt_t
                heapq.heappush(q, (nxt_t, k, nxt))
            if k < K:
                if t < distance[k+1][nxt]:
                    distance[k+1][nxt] = t
                    heapq.heappush(q, (t, k+1, nxt))
    min_d = sys.maxsize
    for i in range(K+1):
        min_d = min(min_d, distance[i][N])
    return min_d

print(dijkstra())
