import sys

input = sys.stdin.readline

# Snakey String (35367번)
r, c = map(int, input().rstrip().split())
board = [input().rstrip() for _ in range(r)]
ans = ""
for i in range(c):
    for j in range(r):
        if board[j][i] != ".":
            ans += board[j][i]
print(ans)
