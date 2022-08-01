# 고속도로(1884번)
##########################################################################################################
    # 문제: https://www.acmicpc.net/problem/1884
    # DP, 다익스트라
    # 어제부터 오랜만에 다시 다익스트라 알고리즘을 접하고 있다.
    # K의 비용으로 N에 왔다 => distance[k][n]라는 생각으로 2차원의 최단거리 테이블을 만들고
    # 다익스트라 알고리즘을 구현하였고 통과했다
    # 2456ms로 통과했는데, 나는 내 풀이도 잘 풀었다고 생각했는데 1등의 풀이를 보니 96ms여서 깜짝 놀랐다.
    # 풀이를 자세히 보니 정말 효율적으로 잘 풀었다고 생각한다. 사실 크게 특별한 것이 없었다. 나는 왜 저렇게 생각하지 못했나라는 생각이 들 정도였다.
    # 통행료 예산이 주어져있으니, 누적 최단 거리를 기준으로 한 최소 힙을 예산이 허락하는 한에서 계속 요소를 뽑고 넣고를 반복하다가
    # 위치가 N이면 flag 변수를 true로 바꾸고 break하고 지금까지의 누적 최단 거리를 출력하고, 큐에서 모든 요소가 나갈 때까지 반복했는데
    # flag 변수가 false이면 -1을 출력하게 하였다.
##########################################################################################################
import sys, heapq
input = sys.stdin.readline

K = int(input()) # 교통비
N = int(input()) # 도시 수
R = int(input()) # 도로 정보의 수
graph = [[] for _ in range(N + 1)]
for _ in range(R):
    s, d, l, t = map(int, input().split())
    graph[s].append((d, l, t)) # 도착점, 거리, 통행료

def dijkstra():
    pq = []
    heapq.heappush(pq, (0, 0, 1)) # 거리, 도착점
    INF = sys.maxsize
    distance = [[INF for _ in range(N + 1)] for _ in range(K + 1)] # K의 비용으로 N에 왔다 => distance[k][n]
    distance[0][1] = 0
    while pq:
        cur_l, cur_t, cur = heapq.heappop(pq)
        if distance[cur_t][cur] < cur_l:
            continue
        for nxt, nxt_l, nxt_t in graph[cur]:
            k = nxt_t + cur_t
            if k <= K:
                d = nxt_l + cur_l
                if d < distance[k][nxt]:
                    distance[k][nxt] = d
                    heapq.heappush(pq, (d, k, nxt))

    sd = INF
    for k in range(K + 1):
        sd = min(sd, distance[k][N])

    return sd if sd != INF else -1

sd = dijkstra()
print(sd)
#####################################################################################################
# 96ms 통과 코드
K, N, R = int(input()), int(input()), int(input())
L = [[] for _ in range(N + 1)]
for i in range(R):
    s, d, l, t = map(int, input().split())
    L[s].append([l, t, d])

heap = []
heapq.heappush(heap, (0, 0, 1))

J = 0
while heap:
    SL, ST, SN = heapq.heappop(heap)

    if SN == N: # 최소힙에서 뽑은 노드가 도착 노드면 flag = True로 하여 break
        J = 1
        break

    for FL, FT, FN in L[SN]:
        d = SL + FL
        t = ST + FT

        if K >= t: # 누적 최단 거리를 기준으로 누적 통행료가 K이하이면 최소 힙에 넣는다.
            heapq.heappush(heap, (d, t, FN))

print(SL if J else -1)
