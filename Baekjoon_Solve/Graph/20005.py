# 보스몬스터 전리품(20005번)
##############################################################################################
    # 문제: https://www.acmicpc.net/problem/20005
    # BFS, 시뮬레이션, 구현
    # Python3 시간초과, Pypy3 1460ms 통과
    # 내 풀이는 이렇다. 일단 3차원의 visited배열을 선언한다.(플레이어의 번호별로 2차원의 visited배열을 가지는 셈) *플레이어의 번호: ord(플레이어 아이디) - 97
    # 그리고 각 플레이어의 좌표를 구하고, 큐에 넣고 해당 위치를 "."으로 바꿔서 지나갈 수 있게 해주고, 플레이어의 번호에 해당하는 배열에 방문 체크를 한다.
    # 배열의 길이가 26인 dps확인 배열을 선언하고 각 플레이어의 번호에 해당하는 인덱스에 dps를 기록한다
    # 보스의 체력이 0보다 큰 동안 while 구문을 돌면서 플레이어를 BFS 탐색으로 이동시킨다. 이 때, 플레이어가 보스 좌표에 도달하면
    # deal에 해당 플레이어의 dps를 더해주고, 플레이어의 수를 += 1해준다.
    # 매회차(큐의 길이)마다 보스의 체력에서 deal을 빼줘서 보스 몬스터의 체력을 감소시킨다.
    # 보스의 체력이 0 이하이면 플레이어의 수를 출력한다.
    # Python3로 시간초과를 받았고 Pypy3로도 1000ms대의 시간이 걸려서 Python3로 푼 풀이를 보니까 확실히 효율적이었다.
    # 내 풀이가 모든 플레이어가 보스 몬스터까지 도달하는 방법으로 접근했다면, 효율적인 풀이는 보스몬스터가 플레이어까지 이동하는 것이었다.
    # 보스몬스터가 플레이어까지 이동하는 방법을 사용하면 3차원의 vistied 배열이 필요없이 단순 2차원의 방문 배열로도 가능하고, q에 들어갔다 나오는 요소의 개수도
    # 확실히 적어서 시간적, 메모리적으로 많이 효율적인 풀이이다.
    # 너무 정직하게 문제에서 주어진 조건으로 접근한듯하다. 잘못됐다는 것은 아니지만, 그래도 이런식으로 효과적으로 접근하는 방법도 숙지해야겠다.
##############################################################################################
import sys
from collections import deque
input = sys.stdin.readline

dydx = [(-1, 0), (0, 1), (1, 0), (0, -1)]

M, N, P = map(int, input().split()) # 지도 세로, 가로, 플레이어 수

q = deque()
graph = []
visited = [[[False for _ in range(N)] for _ in range(M)] for _ in range(P)]
for i in range(M):
    lst = list(input().rstrip())
    for j in range(N):
        if 'a' <= lst[j] <= 'z':
            pn = ord(lst[j]) - 97
            q.append((i, j, pn))
            lst[j] = "."
            visited[pn][i][j] = True
    graph.append(lst)

dps_lst = [0] * 26
for _ in range(P):
    pid, dps = input().rstrip().split()
    dps_lst[ord(pid) - 97] += int(dps)

Bhp = int(input())

max_P = 0
deal = 0

while Bhp > 0:
    n = len(q)
    for _ in range(n):
        y, x, pn = q.popleft()
        for dy, dx in dydx:
            ny, nx = y + dy, x + dx
            if 0 <= ny < M and 0 <= nx < N and not visited[pn][ny][nx]:
                if graph[ny][nx] == ".":
                    visited[pn][ny][nx] = True
                    q.append((ny, nx, pn))
                elif graph[ny][nx] == "B":
                    visited[pn][ny][nx] = True
                    deal += dps_lst[pn]
                    max_P += 1
    Bhp -= deal

print(max_P)
