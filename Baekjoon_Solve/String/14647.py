# 준오는 조류혐오야!! (14647번)
import sys
input = sys.stdin.readline

n, m = map(int, input().rstrip().split())
board = []
total = 0
for i in range(n):
    lst = list(input().rstrip().split())
    board.append(lst)
    for j in range(m):
        for s in lst[j]:
            if s == "9":
                total += 1

ans = 0
for i in range(n):
    cnt = 0
    for j in range(m):
        for s in board[i][j]:
            if s == "9":
                cnt += 1
    ans = max(ans, cnt)


for i in range(m):
    cnt = 0
    for j in range(n):
        for s in board[j][i]:
            if s == "9":
                cnt += 1
    ans = max(ans, cnt)

print(total - ans)

