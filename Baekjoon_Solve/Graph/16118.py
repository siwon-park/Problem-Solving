# 달빛 여우(16118번)
########################################################################
    # 문제: https://www.acmicpc.net/problem/16118
    # 다익스트라
    # 푸는데 2시간이나 걸렸다. 문제 자체가 어렵기보다는 시간제한 때문에 효율성을 추구해야했다.
    # 늑대가 지금까지 온 상태에 따라 간선의 가중치를 달리하여 다익스트라를 1번만 돌리게 하여 문제를 풀려고 시도했으나
    # 43%에서 시간초과 판정을 받았다.
    # 그래서 다익스트라 함수 내부에 if문에 따른 비효율을 제거하기 위해 다익스트라를 2번 돌리는 방법으로 시도하였으나
    # 50%에서 틀렸습니다 판정을 받았다. 그 이유는 속도가 2배, 1/2배 되기 때문에 홀수 순환간선을 타고 간 다음 해당 좌표로 가는게
    # 더 짧은 시간이 걸리는 케이스가 있었다.
    # 이를 해결해주려고 distance[s] = [0, 0]을 했던 것을 distance[s][1] = 0만 해줬는데 43%의 벽을 넘지 못하였다.
    # 질문게시판을 추가로 참고하여 여우와 늑대의 그래프를 각각 만들었다는 것을 힌트로 삼아 풀 수 있었다.
    # 그래프를 따로 만드는 것보다 따로 만들 때 그래프의 크기를 달리해줘야한다는 아이디어가 떠오르지 않으면 쉽지 않을 것 같다.
########################################################################
import sys, heapq
input = sys.stdin.readline

N, M = map(int, input().split())
graph1 = [[] for _ in range(N + 1)]
graph2 = [[] for _ in range(2*N + 1)]
for _ in range(M):
    a, b, d = map(int, input().split())
    graph1[a].append((b, d))
    graph1[b].append((a, d))
    
    # 1 ~ N 번째 간선은 2배의 속도로 갈 수 있고, N+1 ~ N+N 번째 간선은 1/2배의 속도로 가는 것이라고 그래프를 만듦
    graph2[a].append((b + N, d/2)) # a에서 b+N으로 갈 때는 2배의 속도로 갈 수 있고
    graph2[b + N].append((a, d*2)) # 역으로 돌아올 때는 1/2배의 속도로 갈 수 있다.
    graph2[b].append((a + N, d/2))
    graph2[a + N].append((b, d*2))

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
    f, w1, w2 = fox_dist[i], wolf_dist[i], wolf_dist[i+N]
    if f < w1 and f < w2:
        cnt += 1
print(cnt)

# print(fox_dist[1:])
# print(wolf_dist[1:])
