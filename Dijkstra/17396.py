# 백도어(17396번)
##########################################################################
    # 문제: https://www.acmicpc.net/problem/17396
    # 다익스트라
    # 0에서 N-1까지 가는데, A[i]의 값에 따라 그곳으로 갈 수 있음 유무가 갈린다.
    # N-1은 도착해야하는 곳이고 A[N-1]은 무조건 보이는 곳이므로 N-1에 대해서만 따로 처리를 해주면 된다.
    # 마지막으로 양방향 그래프임을 유의하고, 간선의 가중치가 존재하므로 다익스트라 알고리즘으로 해결하면 된다.
##########################################################################
import sys, heapq
input = sys.stdin.readline

N, M = map(int, input().split())
A = list(map(int, input().split()))

graph = [[] for _ in range(N)]
for _ in range(M):
    a, b, t = map(int, input().split())
    # 양방향 그래프
    graph[a].append((b, t))
    graph[b].append((a, t))

INF = sys.maxsize
# 0에서 N-1까지 가는데, N-1은 보일 수 밖에 없으니 무조건 감
def dijkstra(s, e):
    q = []
    heapq.heappush(q, (0, s))
    distance = [INF] * N
    distance[s] = 0
    flag = False
    while q:
        d, cur = heapq.heappop(q)
        if distance[cur] < d:
            continue
        if cur == e:
            flag = True
            break
        for nxt, t in graph[cur]:
            if not A[nxt]:
                nxt_time = d + t
                if nxt_time < distance[nxt]:
                    distance[nxt] = nxt_time
                    heapq.heappush(q, (nxt_time, nxt))
            elif nxt == e:
                nxt_time = d + t
                if nxt_time < distance[nxt]:
                    distance[nxt] = nxt_time
                    heapq.heappush(q, (nxt_time, nxt))
    if flag:
        return d
    return -1

print(dijkstra(0, N - 1))
