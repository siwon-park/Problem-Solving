# 지뢰찾기 (4108번)
import sys
input = sys.stdin.readline

dydx = [(-1, 0), (-1, 1), (0, 1), (1, 1), (1, 0), (1, -1), (0, -1), (-1, -1)]


def check():
    for i in range(R):
        for j in range(C):
            if board[i][j] == 0:
                for k in range(8):
                    ny = i + dydx[k][0]
                    nx = j + dydx[k][1]
                    if ny < 0 or ny >= R or nx < 0 or nx >= C:
                        continue
                    if board[ny][nx] == '*':
                        board[i][j] += 1


while True:
    R, C = map(int, input().rstrip().split())
    if R == 0 and C == 0:
        break
    board = []
    for i in range(R):
        board.append(list(input().rstrip()))
        for j in range(C):
            if board[i][j] == '.':
                board[i][j] = 0
    check()
    for lst in board:
        print("".join(map(str, lst)))
