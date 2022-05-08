# 개코전쟁(2325번)
###########################################################################################
    # 문제: https://www.acmicpc.net/problem/2325
    # 다익스트라
    # 간선을 하나 제거하는 다익스트라 문제이다. 이전에 풀었던 문제와 비슷한 유형이어서 참고해서 풀었으나 Python3는 시간초과, Pypy3는 7152ms로 겨우 통과
    # 나름 제출 전에 최적화를 해줬다고 했는데, 최적화 없이 제출했다면 Pypy도 시간초과였을 것이다.
    # 간선의 수인 M개만큼 도로를 파괴해보면서 다익스트라를 돌리는 것이 아니라, 길이가 N인 path 배열에 노드를 기록한 뒤에 도로를 N번 막는 방식으로 구현하였다.
    # 그런데 다른 사람 풀이를 보니까 N번 보다 훨씬 덜 돌릴 수도 있다는 것을 깨달았다. path배열을 만들 생각을 했으면서 왜 이렇게 생각 못했나 싶다.
    # path 배열을 활용하여 N에서 역추적하여 최단 거리 경로를 구하면 그 최단 거리 경로의 배열 길이는 N 이하일 수도 있다.
    # route에 N에서 출발하여 경로를 역추적한 좌표만 담아서 a, b = route[i], route[i+1]로 지정해서 도로를 파괴하니 훨씬 더 빠르게 해결 가능했다.
    # Pypy3 기준 7152ms -> 604ms로, Python3는 2436ms로 통과할 수 있었다. 엄청난 개선이다.
###########################################################################################
import sys, heapq
input = sys.stdin.readline

def dijkstra(a, b):
    q = []
    heapq.heappush(q, (0, 1)) # 거리, 노드
    distance = [INF] * (N + 1)
    distance[1] = 0
    while q:
        d, cur = heapq.heappop(q)
        if distance[cur] < d:
            continue
        for nxt, cost in graph[cur]:
            # 없앤 도로면 지나가지 않음
            if (cur, nxt) == (a, b) or (cur, nxt) == (b, a):
                continue
            nxt_d = d + cost
            if nxt_d < distance[nxt]:
                distance[nxt] = nxt_d
                heapq.heappush(q, (nxt_d, nxt))
                path[nxt] = cur
    return distance

N, M = map(int, input().split())
graph = [[] for _ in range(N + 1)]

INF = sys.maxsize
for _ in range(M):
    x, y, z = map(int, input().split())
    graph[x].append((y, z))
    graph[y].append((x, z))

path = [i for i in range(N + 1)] # 최단 거리 경로를 기록할 배열
path[1] = 0 # 1번이 출발지이므로 1번의 부모를 0으로 초기화
dijkstra(0, 0) # 최단 거리 경로를 기록하기 위해 다익스트라를 1번 돌림. (0, 0)인 경우는 없으므로 안전함

route = [] # route를 활용(N번 돌리는 것보다 덜 돌릴 수 있음)
cur = N
while cur:
    route.append(cur)
    cur = path[cur]
# print(route)

max_d = -INF
for i in range(len(route) - 1):
    a, b = route[i], route[i + 1] # 없앨 도로
    d = dijkstra(a, b)[N]
    max_d = max(max_d, d)

print(max_d)
