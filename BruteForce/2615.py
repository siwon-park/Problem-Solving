# 오목(2615번)
############################################################
    # 문제: https://www.acmicpc.net/problem/2615
    # 구현, 브루트포스
    # 방문에 대해 중복처리를 안 해줘서 1번 틀렸고, (1,-1)으로 이동했을 때에 대해 가장 왼쪽 좌표를 얻는 데에 있어 처리를 잘 못해줘서 1번 더 틀렸음
############################################################
import sys
from collections import deque
input = sys.stdin.readline

board = [list(map(int, input().split())) for _ in range(19)]
visited = [[[False, False, False, False] for j in range(19)] for i in range(19)]
dydx = [(1, 0), (0, 1), (1, -1), (1, 1)] # 가장 왼쪽 좌표를 얻기 위해 좌표값을 이와 같이 설정함(단, 2번 인덱스에 대한 예외 처리 필요)

def game():
    for i in range(19):
        for j in range(19):
            if board[i][j] != 0:
                for k in range(4):
                    if not visited[i][j][k]:
                        q = deque([(board[i][j], i, j)]) # 흑백, y좌표, x좌표
                        visited[i][j][k] = True
                        dy, dx = dydx[k]
                        cnt = 1
                        while q:
                            bw, y, x = q.popleft()
                            ny, nx = y+dy, x+dx
                            if 0 <= ny < 19 and 0 <= nx < 19:
                                if board[ny][nx] == bw and not visited[ny][nx][k]:
                                    cnt += 1
                                    q.append((bw, ny, nx))
                                    visited[ny][nx][k] = True
                        if cnt == 5:
                            if k == 2: # (1, -1)에 대한 가장 왼쪽 케이스 예외 처리 (우상단에서 출발해서 좌하단으로 이동하니까 가장 좌측 좌표는 ny-dy, nx-dx임)
                                return ny-dy, nx-dx
                            return i, j
    return 0

res = game()

if not res:
    print(res)
else:
    print(board[res[0]][res[1]])
    print(res[0]+1, res[1]+1)
