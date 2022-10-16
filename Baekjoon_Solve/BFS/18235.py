# 지금 만나러 갑니다(18235번)
####################################################################################
    # 문제: https://www.acmicpc.net/problem/18235
    # BFS
    # 디버깅에 많은 시간을 소비했다. 시간초과를 받았는데, 그냥 한 번 Pypy3로도 제출해볼 걸 그랬다.
    # 처음에는 visited[N+1][4] 크기로 배열을 선언해서 접근했다. 4는 (-1, -1), (1, -1), (1, 1), (-1, 1)로 오리, 육리가 움직이는 경우의 수이다.
    # 해당 풀이법으로 1%에서 자꾸 시간초과가 나서 다른 방식으로 접근했다.
    # N의 최대 크기가 50만이므로, 2^19 = 524288로 50만을 넘는다. 따라서 만나기 전까지 최대 이동가능한 일수는 19일이다.
    # 1일차에는 2^0만큼, 2일차에는 2^1 움직이므로, 19일 차에는 2^18만큼 움직이는 것이다. 따라서 visited[N+1][20] 크기의 배열을 선언한다. 
    # visited[위치][날짜]의 개념으로 접근하였다. 각 각 오리, 육리의 방문 배열을 반환한 뒤에 특정 날짜에서 해당 위치의 값이 둘 다 True이면, 해당 날짜를 return 하였다.
####################################################################################
import sys
from collections import deque
input = sys.stdin.readline

N, A, B = map(int, input().split()) # 범위, 오리 위치, 육리 위치

def bfs(s):
    visited = [[False for _ in range(20)] for _ in range(N + 1)]
    visited[s][0] = True
    q = deque([(0, s)])
    while q:
        d, cur = q.popleft()
        for k in [-1, 1]:
            nxt = cur + k * 2 ** d
            if 0 < nxt < N + 1 and d + 1 <= 19 and not visited[nxt][d + 1]:
                visited[nxt][d + 1] = True
                q.append((d + 1, nxt))
    return visited

v1 = bfs(A)
v2 = bfs(B)

def possible(v1, v2):
    for j in range(20):
        for i in range(1, N + 1):
            if v1[i][j] == v2[i][j] == True:
                return j
    return -1

d = possible(v1, v2)
print(d)
