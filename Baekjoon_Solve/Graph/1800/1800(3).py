import sys, heapq
input = sys.stdin.readline

N, P, K = map(int, input().rstrip().split()) # 노드 수, 간선 수, 공짜 케이블 수
graph = [[] for _ in range(N + 1)]
max_cost = 0 # 최대 비용
INF = int(1e9)
for _ in range(P):
    a, b, c = map(int, input().rstrip().split()) # 노드1, 노드2, 비용
    max_cost = max(max_cost, c)
    graph[a].append((b, c))
    graph[b].append((a, c))


def binary_search() -> int:
    s = 0
    e = max_cost
    ans = -1
    while s <= e:
        mid = (s + e) // 2 # 지불하는 최솟값
        cnt = dijkstra(mid) # mid 이상의 비용을 지불하지 않고 N까지 갈 수 있는 횟수
        if 0 <= cnt <= K: # 횟수가 0 이상 K이하면 mid값을 낮춰서 탐색해 봄
            e = mid - 1
            ans = mid
        else:
            s = mid + 1
    return ans

def dijkstra(max_pay: int) -> int:
    distance = [INF for _ in range(N + 1)]
    distance[1] = 0
    pq = []
    heapq.heappush(pq, (0, 1)) # 공짜 횟수, 노드

    while pq:
        k, cur = heapq.heappop(pq)
        if distance[cur] < k:
            continue
        if cur == N:
            return k
        for nxt, cost in graph[cur]:
            if cost > max_pay:
                if k + 1 < distance[nxt]: # 다음 비용이 max_pay보다 크고 공짜 횟수가 K보다 작으면
                    distance[nxt] = k + 1
                    heapq.heappush(pq, (k + 1, nxt))
            elif k < distance[nxt]:
                distance[nxt] = k
                heapq.heappush(pq, (k, nxt))
    return -1

print(binary_search())