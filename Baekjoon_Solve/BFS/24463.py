# 미로(24463번)
###################################################################
    # 문제: https://www.acmicpc.net/problem/24463
    # BFS, 그래프 이론
    # 구현 자체는 어렵지 않았으나, 시간초과를 줄이려고 노력했음. 아마 더 빠른 풀이가 가능할 것이라 판단됨
    # 아이디어는 간단함. 출발지에서 BFS탐색을 하여 출구를 찾으면서 visited 배열에 거리를 기록해주고
    # 출구에서 거리가 1차이 나는 경로만 골라서 출발지까지 가면 그것이 최단 거리이므로 그 경로에 대해서 board[y][x] = "."을 표시해줬다.
    # Pypy3 통과 시간을 줄이고 Python3로 통과하기 위해서 BFS 탐색 부분을 함수로 감쌌고, 초기에 그래프를 입력받을 때 오히려 "."을 모두 "@"으로 표시해줬다.
    # 그리고 첫번째 BFS탐색을 하면서 출구를 찾으면 바로 return하게 하여 시간을 줄였다.
###################################################################
import sys
from collections import deque
input = sys.stdin.readline

INF = int(1e9)
dydx = [(-1, 0), (0, 1), (1, 0), (0, -1)]
N, M = map(int, input().split())
board = []
for i in range(N):
    board.append(list(input().rstrip()))
    for j in range(M):
        if board[i][j] == ".":
            board[i][j] = "@" # .을 모두 @으로 변환

# 출발지 또는 출구 찾기
def find_start():
    for i in range(M):
        if board[0][i] == "@":
            return 0, i
        elif board[N-1][i] == "@":
            return N-1, i
    for i in range(N):
        if board[i][0] == "@":
            return i, 0
        elif board[i][M-1] == "@":
            return i, M-1

# 너비 우선 탐색 함수
def bfs1():
    while q:
        y, x = q.popleft()
        for dy, dx in dydx:
            ny, nx = y+dy, x+dx
            if 0 <= ny < N and 0 <= nx < M:
                if board[ny][nx] == "@" and visited[y][x] + 1 < visited[ny][nx]:
                    visited[ny][nx] = visited[y][x] + 1
                    q.append((ny,nx))
            else: # 출구 기록
                if (sy, sx) != (y, x):
                    return y, x

# bfs2 함수: 출구에서부터 역으로 출발해서최단 경로로 지나온 것에 대해 @을 .으로 바꿈
def bfs2():
    while q:
        y, x = q.popleft()
        board[y][x] = "."
        for dy, dx in dydx:
            ny, nx = y+dy, x+dx
            if 0 <= ny < N and 0 <= nx < M:
                if board[ny][nx] == "@" and visited[ny][nx] == visited[y][x]-1:
                    q.append((ny, nx))

sy, sx = find_start()
q = deque([(sy, sx)])
visited = [[INF]*M for _ in range(N)]
visited[sy][sx] = 0
ty, tx = bfs1()

q = deque([(ty, tx)])
bfs2()

for lst in board:
    print("".join(lst))
