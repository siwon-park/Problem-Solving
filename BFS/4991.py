# 로봇 청소기(4991번)
##################################################################################################
    # 문제: https://www.acmicpc.net/problem/4991
    # BFS, 비트마스킹
    # BFS를 하되, 비트마스킹을 하면서 최단거리를 구하는 문제이다.
    # 비트 연산을 잘 할 수 있으면 크게 어렵지 않게 풀 수 있는 문제이다.
##################################################################################################
import sys
from collections import deque
input = sys.stdin.readline
INF = sys.maxsize
dydx = [(-1, 0), (0, 1), (1, 0), (0, -1)]

def bfs(q):
    while q:
        k, y, x = q.popleft()
        if not (k ^ 2**cnt - 1): # 비트 XOR연산; 두 비트의 값이 같으면 0, 아니면 1
            return visited[y][x][k]
        for dy, dx in dydx:
            ny, nx = y + dy, x + dx
            if 0 <= ny < h and 0 <= nx < w and board[ny][nx] != "x":
                if board[ny][nx] == ".":
                    if visited[y][x][k] + 1 < visited[ny][nx][k]:
                        visited[ny][nx][k] = visited[y][x][k] + 1
                        q.append((k, ny, nx))
                elif board[ny][nx] != ".":
                    if not k & (1 << board[ny][nx]): # 1 << board[ny][nx]의 자리 비트가 1인지 확인
                        new_k = k | (1 << board[ny][nx]) # 1 << board[ny][nx] 자리의 비트를 1로 바꿈
                        if visited[y][x][k] + 1 < visited[ny][nx][new_k]:
                            visited[ny][nx][new_k] = visited[y][x][k] + 1
                            q.append((new_k, ny, nx))
                    else:
                        if visited[y][x][k] + 1 < visited[ny][nx][k]:
                            visited[ny][nx][k] = visited[y][x][k] + 1
                            q.append((k, ny, nx))
    return - 1


while True:
    w, h = map(int, input().split())
    if (w, h) == (0, 0):
        break
    board = []
    q = deque()
    visited = [[[INF] * (1 << 10) for _ in range(w)] for _ in range(h)]
    cnt = 0
    for i in range(h):
        board.append(list(input().rstrip()))
        for j in range(w):
            if board[i][j] == "o":
                q.append((0, i, j))
                visited[i][j][0] = 0
                board[i][j] = "."
            elif board[i][j] == "*":
                board[i][j] = cnt
                cnt += 1

    print(bfs(q))
