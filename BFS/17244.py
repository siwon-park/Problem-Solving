# 아맞다우산(17244번)
###########################################################################################
    # 문제: https://www.acmicpc.net/problem/17244
    # BFS, 비트마스킹
    # 비트마스킹이 필요한 BFS문제. 물건을 집는 순서에 따라 E까지 가는 최단 거리가 달라지는 형태이기 때문에, 물건을 집는 순서를 고려한 BFS탐색을 해야한다.
    # 아직 비트마스킹에 대해 친숙하지 않아서 이전에 내가 풀었던 비슷한 문제의 풀이를 참고해서 풀었다.(물론 그 문제 또한 다른 곳에서 힌트를 얻어 풀었다.)
    # &(비트 AND)연산으로 특정 순서의 물건을 집었는지 확인하고,
    # 집지 않았다면 |(비트 OR)연산으로 특정 자리 비트를 1로 변경하여 집은 것으로 마킹하고 탐색을 진행하게 하였다.
    # 그리고 만약 모든 물건을 다 집은 상태라면 모든 자리의 비트가 1이므로, ^(비트 XOR)연산으로 2**X_cnt - 1과 모든 비트가 일치하는지 체크하여
    # 모든 자리 비트가 (1로) 일치한다면 0을 반환하고, 아니라면 1을 반환하므로
    # 도착지점이면서 not (k ^ 2**X_cnt - 1)이면 그 때의 거리 + 1의 값을 반환하게 하였다.
    # 처음에 23%에서 틀렸습니다 판정을 받았는데, 생각해보니
    # 물건을 집고 다시 "S"의 위치로 돌아와야하는 경우도 있는데 그 경우에 대한 처리를 해주지 않아서 그랬다.
    # 그래서 제일 처음에 "S"의 위치를 기록하고 해당 위치를 "."으로 변경하여 정상적으로 돌아갈 수 있게 만들어주었더니 통과할 수 있었다.
###########################################################################################
import sys
from collections import deque
input = sys.stdin.readline

M, N = map(int, input().split())
board = []
X_cnt = 0
for i in range(N):
    board.append(list(input().rstrip()))
    for j in range(M):
        if board[i][j] == "S":
            board[i][j] = "." # "S"를 "."으로 바꿔줘야 k값이 다를 때 "S"의 위치로 갈 수 있음
            sy, sx = i, j
        elif board[i][j] == "X": # 비트마스킹을 위해 X를 숫자로 변경함
            board[i][j] = X_cnt
            X_cnt += 1

dydx = [(-1, 0), (0, 1), (1, 0), (0, -1)]

INF = sys.maxsize
visited = [[[INF] * (1 << X_cnt) for _ in range(M)] for _ in range(N)]

def bfs():
    q = deque([(0, 0, sy, sx)])
    visited[sy][sx][0] = 0
    while q:
        k, d, y, x = q.popleft() # 현재 물건을 집은 상태, 거리, y좌표, x좌표
        for dy, dx in dydx:
            ny, nx = y + dy, x + dx
            if 0 <= ny < N and 0 <= nx < M and board[ny][nx] != "#":
                if board[ny][nx] == "E" and not (k ^ 2**X_cnt - 1): # 도착점이고, 모든 물건을 다 집은 상태면 return
                    return d + 1
                elif board[ny][nx] == ".":
                    if d + 1 < visited[ny][nx][k]:
                        visited[ny][nx][k] = d + 1
                        q.append((k, d + 1, ny, nx))
                elif not board[ny][nx] == "." and not board[ny][nx] == "E":
                    # 아직 물건을 집은 상태가 아니라면
                    if not k & (1 << board[ny][nx]):
                        new_k = k | (1 << board[ny][nx]) # 물건을 집는다(2^board[ny][nx]자리 비트를 1로 변경)
                        if d + 1 < visited[ny][nx][new_k]:
                            visited[ny][nx][new_k] = d + 1
                            q.append((new_k, d + 1, ny, nx))
                    else: # 물건을 집은 상태라면
                        if d + 1 < visited[ny][nx][k]:
                            visited[ny][nx][k] = d + 1
                            q.append((k, d + 1, ny, nx))
    return -1

print(bfs())
