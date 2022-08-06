# Watering the Fields(10021번)
################################################################
    # 문제: https://www.acmicpc.net/problem/10021
    # 최소 스패닝 트리(최소 스패닝 트리 문제 풀이에도 업로드 함), 다익스트라
    # Python3 시간초과, Pypy3 통과(556ms)
    # 이 문제가 다익스트라로도 해결이 가능한 이유: 2차원의 좌표 평면이고, 사실상 어느 한 점에서 다른 모든 점들까지 도달할 수 있는 구조이다.
    # 2차원의 최단 거리 배열을 선언해도 됐지만, 메모리 낭비를 줄이기 위해 1차원의 최단 거리 배열을 선언했다.
    # 대신에 최단 거리 배열에 대한 로직이 바뀌는데, (일반적으로는 누적 거리를 비교해서 최단 거리를 갱신함)
    # 최초 시작으로 A라는 점에서 출발하고 B, C, D, .... 등 여러 점들까지의 최단 거리 배열을 갱신한다.
    # 그리고 다음 좌표들을 각 각 우선순위에 삽입하게 되고, 각 좌표들에서 또 다른 좌표들에게 이르는 최단 거리로 최단 거리 테이블을 갱신한다.
    # 따라서 사실상 배열은 1차원이지만, 2차원인 것처럼 사용하게 되는 것이다.
    # 그리고 방문 체크와 그 타이밍이 중요했다.(아래 코드에서 설명)
################################################################
import sys, heapq
input = sys.stdin.readline

N, C = map(int, input().split())
lst = []
for i in range(N):
    x, y = map(int, input().split())
    lst.append((x, y))

def dijkstra():   
    q = []
    heapq.heappush(q, (0, 0))
    distance = [int(1e9)] * N
    distance[0] = 0
    visited = [False] * N
    visited[0] = True
    cnt = 1
    while q:
        dist, cur = heapq.heappop(q)
        if not visited[cur] and distance[cur] == dist: # 우선순위 큐에서 나왔을 때, 비로소 그게 진짜 최단 거리이므로 방문을 갱신함
            visited[cur] = True
            cnt += 1
            if cnt == N:
                return sum(distance)
        for i in range(N):
            d = (lst[cur][0] - lst[i][0])**2 + (lst[cur][1] - lst[i][1])**2
            if d >= C and d < distance[i] and not visited[i]: # 여기서 방문을 갱신하지 않는다. 왜냐하면 다른 점에서 i까지의 거리가
                distance[i] = d                               # 현재 점에서 i까지의 거리보다 짧을 수 있기 때문에
                heapq.heappush(q, (d, i))                     # 우선순위 큐에서 나왔을 때 방문을 갱신해준다.
    return -1

print(dijkstra())
