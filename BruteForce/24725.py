# 엠비티아이(24725번)
############################################################
    # 문제: https://www.acmicpc.net/problem/24725
    # 브루트포스
    # DFS로 구현해봤지만, 그리 효율적이진 못한 것 같다.
    # 그냥 for문으로 구현했으면 아마 도중에 mbti에 맞지 않는 문자열일 경우 break하면 되기 때문에
    # 더 빠른 시간 안에 해결 가능했을 것 같다.
############################################################
import sys
input = sys.stdin.readline

dydx = [(-1, -1), (-1, 0), (-1, 1), (0, 1), (1, 1), (1, 0), (1, -1), (0, -1)]

def dfs(y, x, k, n, mbti):
    global cnt
    if n == 4:
        if mbti[1] != "N" and mbti[1] != "S":
            return
        if mbti[2] != "F" and mbti[2] != "T":
            return
        if mbti[3] != "P" and mbti[3] != "J":
            return
        cnt += 1
        return
    dy, dx = dydx[k][0], dydx[k][1]
    ny, nx = y+dy, x+dx
    if 0 <= ny < N and 0 <= nx < M:
        dfs(ny, nx, k, n+1, mbti+board[ny][nx])

N, M = map(int, input().split())
board = [input().rstrip() for _ in range(N)]
cnt = 0
for i in range(N):
    for j in range(M):
        if board[i][j] == "E" or board[i][j] == "I":
            for k in range(8):
                dfs(i, j, k, 1, board[i][j])
print(cnt)
