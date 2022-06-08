# 등산(16681번)
####################################################################################
    # 문제: https://www.acmicpc.net/problem/16681
    # 다익스트라
    # 문제를 잘못 이해하는 바람에 한 30분은 그냥 날렸다. 제발 문제 좀 제대로, 그리고 똑바로 잘 읽어야겠다.
    # 목적지를 찍고, 찍은 목적지에 도착했을 때만 만족도를 1번 계산해야하는데, 나는 노드에 도착할 때마다 만족도를 계산해가면서
    # 최대 만족도를 유지하는 방향으로 가야하는 것으로 이해했다.
    # 그리고 집과 고려대학교는 목적지가 될 수 없다고 분명히 문제에 명시했는데, 마지막에 하산하는 코스에서
    # 고려대학교를 목적지로 가정하여 만족도를 계산해서 빼줘야하는 줄 알았다.
    # 즉, 최종적으로 계산해야하는 만족도는 (목표지점의 높이 * E - 목표지점까지의 거리 * D - 목표지점에서 고려대학교까지의 거리 * D)인데
    # 영 엉뚱한 방향으로 잘못 계산해서 문제의 예시를 계산하는데만 30분을 족히 날린 듯하다.
    # 풀면서 조금 어렵다고 느꼈는데, 문제만 잘 읽었어도 충분히 어렵지 않게 풀 수 있었을 듯하다.
####################################################################################
import sys, heapq
input = sys.stdin.readline

N, M, D, E = map(int, input().split())
h = [0] + list(map(int, input().split()))
graph = [[] for _ in range(N + 1)]
for _ in range(M):
    a, b, n = map(int, input().split())
    graph[a].append((b, n))
    graph[b].append((a, n))

INF = sys.maxsize

def dijkstra(s):
    distance = [INF] * (N + 1)
    distance[s] = 0
    q = []
    heapq.heappush(q, (0, s)) # 거리, 위치
    while q:
        d, cur = heapq.heappop(q)
        if distance[cur] < d:
            continue
        for nxt, n in graph[cur]:
            if h[nxt] > h[cur]:
                nxt_d = d + n
                if nxt_d < distance[nxt]:
                    distance[nxt] = nxt_d
                    heapq.heappush(q, (nxt_d, nxt))
    return distance

d1 = dijkstra(1) # 집에서 목표까지의 최단 거리 테이블
d2 = dijkstra(N) # 고려대학교에서 목표까지의 최단 거리 테이블

max_sat = -INF # 만족도는 음수가 될 수 있으므로 -sys.maxsize로 선언한다
for i in range(1, N + 1):
    if d1[i] != INF and d2[i] != INF:
        max_sat = max(max_sat, h[i]*E - d1[i]*D - d2[i]*D)
if max_sat != -INF:
    print(max_sat)
else:
    print("Impossible")
