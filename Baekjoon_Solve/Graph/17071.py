# 숨바꼭질 5 (17071번)
#################################################################################################
    # 문제: https://www.acmicpc.net/problem/17071
    # BFS
    # 0.25초 안에 통과해야하므로, 효율성과 최적화를 요구한다.
    # 이 문제를 푸는 핵심은 매초 현재 위치에서 +- 1인 곳을 방문할 수 있기 때문에
    # 짝수/홀수 초에 해당 위치로 갈 수 있다면, 해당 초의 배수 초에서는 항상 그 위치로 갈 수 있다.
    # 이 점을 이용해서 2차원의 방문 배열을 만들고, 짝수/홀수 초에 갈 수 있는 위치에 대한 최단 시간을 기록한다.
    # 만약에 동생이 t1초에 k위치에 있을 때, 방문배열의 k위치에 t2초로 갈 수 있다면,
    # t1 >= t2를 만족하는 t1이 최단 시간이 된다.
    # 동생이 50만을 안 넘는 위치까지 사용할 수 있는 최대 시간 T를 구한 뒤에 0부터 T까지 탐색해서 t1 >= t2를 가장 먼저 만족하는
    # t1을 찾으면 된다.
    # 처음에 비슷한 논리지만, 홀/짝 방문 배열이 아닌 집합형 큐로 구현해보았는데, 초반에는 빠르다가 36%에서 시간초과가 발생했었다.
#################################################################################################
import sys
from collections import deque
input = sys.stdin.readline

N, K = map(int, input().split())
INF = sys.maxsize
MAX_RANGE = 500001

# 동생이 이동할 수 있는 최대 시간과 그때의 위치 반환
def bfs_bro():
    visited = []
    t = 0
    k = K
    while k + t <= 500000:
        visited.append(k + t)
        k = k + t
        t += 1

    return t, visited

def bfs_ssu(T, V):
    q = deque([(0, N)]) # 시간, 현 위치
    visited = [[INF, INF] for _ in range(MAX_RANGE)] # 짝수/홀수 초에 해당 위치에 갈 수 있으면 항상 도착 가능함
    visited[N][0] = 0

    while q:
        t, cur = q.popleft()
        for nxt in [cur + 1, cur - 1, cur * 2]:
            if 0 <= nxt < MAX_RANGE and visited[nxt][(t + 1) % 2] > t + 1:
                visited[nxt][(t + 1) % 2] = t + 1
                q.append((t + 1, nxt))

    for i in range(T):
        if i >= visited[V[i]][i % 2]:
            return i

    return -1

t, bro_v = bfs_bro()

print(bfs_ssu(t, bro_v))
