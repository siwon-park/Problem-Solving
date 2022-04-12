# 미로 탈출(14923번)
################################################################################################
    # 문제: https://www.acmicpc.net/problem/14923
    # BFS
    # 벽 뚫고 이동하기와 같은 로직의 문제
    # 처음에 4496ms로 통과했으나 비효율적인 부분을 수정하여 2188ms로 줄일 수 있었다.
    # BFS는 항상 처음 도착한 곳에 대해 최단 거리를 보장하므로, 벽을 뚫고 가나 안 뚫고 가나 BFS로 해당 위치에 처음 도달했다면 최단거리다
    # 따라서 방문 배열에 가장 큰 값을 넣고 초기화 한뒤에 BFS를 돌리면서 대소비교를 해가면서 최단거리를 기록 할 필요가 없이 그냥 아직 방문하지 않은 곳이면 갱신해주면 된다.
################################################################################################
import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())
Hx, Hy = map(lambda x: int(x) - 1, input().split())
Ex, Ey = map(lambda x: int(x) - 1, input().split())

board = [list(map(int, input().split())) for _ in range(N)]

dydx = [(-1, 0), (0, 1), (1, 0), (0, -1)]

def bfs():
    q = deque([(0, Hx, Hy)])
    visited = [[[0, 0] for j in range(M)] for i in range(N)]
    while q:
        used, y, x = q.popleft()
        if (y, x) == (Ex, Ey):
            return visited[y][x][used]
        for dy, dx in dydx:
            ny, nx = y + dy, x + dx
            if 0 <= ny < N and 0 <= nx < M:
                if not visited[ny][nx][used]:
                    if not board[ny][nx]:
                        visited[ny][nx][used] = visited[y][x][used] + 1
                        q.append((used, ny, nx))
                    elif used == 0:
                        visited[ny][nx][1] = visited[y][x][0] + 1
                        q.append((1, ny, nx)) 
    return -1

print(bfs())
