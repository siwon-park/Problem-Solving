# 배달(1175번)
########################################################################################
    # 문제: https://www.acmicpc.net/problem/1175
    # BFS, 비트마스킹
    # 생각보다 문제가 쉬운 편은 아니었다고 본다.
    # 왜냐하면 비트마스킹과 연속된 방향을 피하기 위해서 4차원의 그래프를 사용하는 등 복잡함이 조금 있었기 때문이다.
    # 자세한 문제 해설은 주석을 참고
########################################################################################
import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())
dydx = [(-1, 0), (0, 1), (1, 0), (0, -1)]
graph = []
INF = sys.maxsize
visited = [[[[INF]*(1 << 2) for _ in range(M)] for _ in range(N)] for _ in range(4)] # [방문방향][y좌표][x좌표][선물의 비트]
q = deque()
C_cnt = 0 # 비트마스킹을 위한 숫자
for i in range(N):
    lst = list(input().rstrip())
    for j in range(M):
        if lst[j] == "S":
            q.append((-1, 0, 0, i, j)) # 초기 방향, C의 개수, 이동 횟수, y좌표, x좌표
            lst[j] = "."
            visited[0][i][j][0] = 0
            visited[1][i][j][0] = 0
            visited[2][i][j][0] = 0
            visited[3][i][j][0] = 0
        elif lst[j] == "C":
            lst[j] = C_cnt
            C_cnt += 1
    graph.append(lst)

def bfs():
    while q:
        d, c, m, y, x = q.popleft()
        if not (c ^ 2**C_cnt - 1): # 비트 xor연산 => 0이나오면 모두 일치함
            return visited[d][y][x][c]
        for k in range(4):
            if d == k: # 같은 방향은 연속적으로 이동 불가능함
                continue
            dy = dydx[k][0]
            dx = dydx[k][1]
            ny, nx = y + dy, x + dx
            if 0 <= ny < N and 0 <= nx < M and graph[ny][nx] != "#":
                if graph[ny][nx] == "." and visited[k][ny][nx][c] == INF:
                    visited[k][ny][nx][c] = m + 1
                    q.append((k, c, m + 1, ny, nx))
                elif graph[ny][nx] != ".":
                    if not c & (1 << graph[ny][nx]): # 아직 해당 선물(C)을 나눠주지 않았으면(해당 위치의 비트가 일치하지 않으면)
                        new_c = c | (1 << graph[ny][nx]) # 방문할 자리 위치의 비트를 변경
                        if visited[k][ny][nx][new_c] == INF:
                            visited[k][ny][nx][new_c] = m + 1
                            q.append((k, new_c, m + 1, ny, nx))
                    else:
                        if visited[k][ny][nx][c] == INF:
                            visited[k][ny][nx][c] = m + 1
                            q.append((k, c, m + 1, ny, nx))

    return -1

d = bfs()
print(d)
