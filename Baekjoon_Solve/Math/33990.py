import sys

input = sys.stdin.readline

# 3대 512 (33990번)
n = int(input().rstrip())
ans = -1
for i in range(n):
    a, b, c = map(int, input().rstrip().split())
    if a + b + c >= 512:
        if ans == -1:
            ans = a + b + c
        else:
            ans = min(ans, a + b + c)

print(ans)

