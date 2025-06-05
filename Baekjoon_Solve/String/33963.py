# 돈복사 (33936번)
import sys
input = sys.stdin.readline

n = input().rstrip()
l = len(n)
m = int(n)
ans = 0
while len(str(m * 2)) == l:
    ans += 1
    m *= 2

print(ans)

