# 카약 (2890번)
import sys
input = sys.stdin.readline

R, C = map(int, input().rstrip().split())
board = []
for i in range(R):
    board.append(input().rstrip())

ranks = [0 for _ in range(10)]
cur = 1
for i in range(C - 2, 0, -1):
    check = False
    for j in range(R):
        if board[j][i] != 'S' and board[j][i] != 'F' and board[j][i] != '.':
            if ranks[int(board[j][i])] == 0:
                ranks[int(board[j][i])] = cur
                check = True
    if check:
        cur += 1

for i in range(1, 10):
    print(ranks[i])

