import sys

input = sys.stdin.readline

# 1, 2, 3, 많다! (34998번)
n = int(input().rstrip())
for _ in range(n):
    x = int(input().rstrip())
    expr = list(input().rstrip().split())
    ans = 0
    for i in range(0, len(expr), 2):
        if expr[i] == '!':
            ans += 10
        else:
            ans += int(expr[i])
    print("!" if ans > 9 else ans)

