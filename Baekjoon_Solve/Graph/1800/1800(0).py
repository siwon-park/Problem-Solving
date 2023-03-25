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
        # K번 까지 mid 이상의 비용은 지불하지 않아도 됨
        cost = dijkstra(mid)
        if cost == INF: # 다익스트라 결과가 INF면 연결 불가능하므로 -1 반환
            return -1
        if cost <= mid: # 최대로 지불한 돈이 mid이하면 mid값을 낮춰서 탐색해봄
            e = mid - 1
            ans = mid
        else:
            s = mid + 1
    return ans


def dijkstra(max_pay: int) -> int:
    distance = [[INF for _ in range(K + 1)] for _ in range(N + 1)] # 횟수 k번으로 특정 노드까지 감
    distance[1][0] = 0
    pq = []
    heapq.heappush(pq, (0, 1, 0)) # 비용, 노드, 공짜 횟수

    while pq:
        tc, cur, k = heapq.heappop(pq)
        if distance[cur][k] < tc:
            continue
        for nxt, cost in graph[cur]:
            if cost >= max_pay and k < K: # 다음 비용이 max_pay 이상이고 공짜 횟수가 K보다 작으면
                if tc < distance[nxt][k + 1]: # 1번 사용하여 tc의 비용으로 다음 위치로 이동
                    distance[nxt][k + 1] = tc
                    heapq.heappush(pq, (tc, nxt, k + 1))
            # 그냥 이동(최대 비용 기록)
            nxt_cost = max(tc, cost)
            if nxt_cost < distance[nxt][k]:
                distance[nxt][k] = nxt_cost
                heapq.heappush(pq, (nxt_cost, nxt, k))

    return min(distance[N])


print(binary_search())