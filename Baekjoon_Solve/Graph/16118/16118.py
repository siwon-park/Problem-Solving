# 달빛 여우 (16118번)
import sys, heapq
input = sys.stdin.readline

N, M = map(int, input().split())
graph1 = [[] for _ in range(N + 1)]
graph2 = [[] for _ in range(2*N + 1)]
for _ in range(M):
    a, b, d = map(int, input().split())
    graph1[a].append((b, d))
    graph1[b].append((a, d))

    graph2[a].append((b + N, d / 2))
    graph2[b + N].append((a, d * 2))
    graph2[b].append((a + N, d / 2))
    graph2[a + N].append((b, d * 2))

def dijkstra(s, graph):
    q = []
    INF = sys.maxsize
    heapq.heappush(q, (0, s))
    distance = [INF] * (len(graph))
    distance[s] = 0
    while q:
        d, cur = heapq.heappop(q)
        if distance[cur] < d:
            continue
        for nxt, cost in graph[cur]:
            nxt_d = d + cost
            if nxt_d < distance[nxt]:
                distance[nxt] = nxt_d
                heapq.heappush(q, (nxt_d, nxt))
    return distance


fox_dist = dijkstra(1, graph1)
wolf_dist = dijkstra(1, graph2)

cnt = 0
for i in range(1, N + 1):
    f, w1, w2 = fox_dist[i], wolf_dist[i], wolf_dist[i + N]
    if f < w1 and f < w2:
        cnt += 1
print(cnt)