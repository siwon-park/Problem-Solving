import sys
import heapq
input = sys.stdin.readline

T = int(input())
INF = int(1e9)


def dijkstra(start_n: int) -> list:
    q = []
    distance = [INF] * (n + 1)
    heapq.heappush(q, (0, start_n))
    distance[start_n] = 0
    while q:
        dist, cur = heapq.heappop(q)
        if distance[cur] < dist:
            continue
        for next, c in graph[cur]:
            cost = dist + c
            if cost < distance[next]:
                distance[next] = cost
                heapq.heappush(q, (cost, next))
    return distance


for _ in range(T):
    n, m, t = map(int, input().split())
    s, g, h = map(int, input().split())
    graph = [[] for i in range(n + 1)]
    for _ in range(m):
        a, b, d = map(int, input().split())
        graph[a].append((b, d))
        graph[b].append((a, d))
    
    s_dist = dijkstra(s)
    h_dist = dijkstra(h)
    g_dist = dijkstra(g)
    candidates = []
    for _ in range(t):
        x = int(input())
        #  g_dist[h] == h_dist[g]으로 중복이기 때문에 전체적으로 한 번만 연산해주면 된다.
        if s_dist[x] == g_dist[h] + min(s_dist[g] + h_dist[x], s_dist[h] + g_dist[x]):
            candidates.append(x)
    candidates.sort()
    print(*candidates)
