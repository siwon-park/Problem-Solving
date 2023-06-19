import sys,heapq
input = sys.stdin.readline

n, m, r = map(int, input().split())
items = list(map(int, input().split()))
graph = [[] * (n + 1) for i in range(n + 1)]
for i in range(r):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))
    graph[b].append((a, c))


def dijkstra(k):
    q = []
    distance = [int(1e9)] * (n + 1)
    heapq.heappush(q, (0, k))
    distance[k] = 0
    while q:
        dist, cur = heapq.heappop(q)
        if distance[cur] < dist:
            continue
        for nxt, cost in graph[cur]:
            new_dist = dist + cost
            if new_dist < distance[nxt]:
                distance[nxt] = new_dist
                heapq.heappush(q, (new_dist, nxt))
    item_count = 0            
    for i in range(1, n + 1):
        if distance[i] <= m:
            item_count += items[i - 1]
    return item_count


max_item = -int(1e9)
for i in range(1, n + 1):
    max_item = max(max_item, dijkstra(i))           
print(max_item)