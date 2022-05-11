# 말이 되고픈 원숭이(1600번)
######################################################################################
    # 문제: https://www.acmicpc.net/problem/1600
    # BFS
    # 벽 뚫고 지나가기와 유사한 문제. H, W <= 200이고, K <= 30이여서 3차원 배열을 통해 풀 수 있었다.
    # 크게 해설할 부분은 없는 것 같다.
######################################################################################
import sys
from collections import deque
input = sys.stdin.readline

K = int(input())
W, H = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(H)]

dydx = [(-1, 0), (0, 1), (1, 0), (0, -1)] # 일반적인 이동
dydx2 = [(-2, -1), (-1, -2), (-2, 1), (-1, 2), (1, 2), (2, 1), (2, -1), (1, -2)] # 말의 이동

def bfs():
    q = deque([(0, 0, 0)]) # k, y, x
    INF = sys.maxsize
    visited = [[[INF]*W for i in range(H)] for j in range(K+1)]
    for k in range(K+1):
        visited[k][0][0] = 0
    while q:
        k, y, x = q.popleft()
        for dy, dx in dydx:
            ny, nx = y + dy, x + dx
            if 0 <= ny < H and 0 <= nx < W and visited[k][ny][nx] == INF:
                if not board[ny][nx]:
                    visited[k][ny][nx] = visited[k][y][x] + 1
                    q.append((k, ny, nx))
        # K번 이하만큼 말이 이동하는 것처럼 이동 가능
        if k < K:
            for dy, dx in dydx2:
                ny, nx = y + dy, x + dx
                if 0 <= ny < H and 0 <= nx < W and visited[k+1][ny][nx] == INF:
                    if not board[ny][nx]:
                        visited[k+1][ny][nx] = visited[k][y][x] + 1
                        q.append((k+1, ny, nx))
    min_dist = INF
    for k in range(K+1):
        if visited[k][H-1][W-1] < min_dist:
            min_dist = visited[k][H-1][W-1]

    return min_dist if min_dist != INF else -1

print(bfs())
