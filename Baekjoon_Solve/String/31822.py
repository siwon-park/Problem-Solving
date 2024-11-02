# 재수강 (31822번)
import sys
input = sys.stdin.readline

L = input().rstrip()
codes = L[:5]
N = int(input().rstrip())
ans = 0
for i in range(N):
    m = input().rstrip()[:5]
    if codes == m:
        ans += 1

print(ans)

