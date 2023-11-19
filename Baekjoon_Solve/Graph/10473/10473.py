# 인간 대포 (10473번)
import math
import sys, heapq
input = sys.stdin.readline

INF = sys.maxsize
nodes = []
A = tuple(map(float, input().rstrip().split()))
B = tuple(map(float, input().rstrip().split()))
nodes.append(A)
nodes.append(B)

n = int(input().rstrip())
for _ in range(n):
    cannon = tuple(map(float, input().rstrip().split()))
    nodes.append(cannon)


def cal_dist(s: tuple, e: tuple) -> float:
    return math.sqrt((abs(s[0] - e[0]) ** 2) + (abs(s[1] - e[1]) ** 2))


def dijkstra(s: int) -> float:
    global B
    distance = [INF for _ in range(n + 2)]
    pq = []
    heapq.heappush(pq, (0, s))
    distance[0] = 0  # 출발지까지의 걸리는 시간은 0
    while pq:
        d, cur = heapq.heappop(pq)
        if distance[cur] < d:
            continue
        if cur == 1:
            return distance[1]
        for i in range(n + 2):
            if i == cur:  # 같은 좌표면 무시
                continue
            nxt = nodes[i]  # 다음 좌표
            total_d = cal_dist(nodes[cur], nxt)
            d1 = total_d / 5  # 5m/s로 해당 거리를 이동함
            if cur >= 2:  # 현재 위치가 대포일 경우
                d2 = 2 + (abs(total_d - 50) / 5)  # 대포를 타고 50m를 이동함 (2초) + 남은 거리를 걸어서 이동함
                d1 = min(d1, d2)
            if d + d1 < distance[i]:
                distance[i] = d + d1
                heapq.heappush(pq, (d + d1, i))
    return distance[1]


print(dijkstra(0))
