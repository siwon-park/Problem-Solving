# 369 (17614번)
import sys
input = sys.stdin.readline

N = int(input().rstrip())
ans = 0
for i in range(1, N + 1):
    num = i
    while num > 0:
        r = num % 10
        if r == 3 or r == 6 or r == 9:
            ans += 1
        num //= 10

print(ans)

