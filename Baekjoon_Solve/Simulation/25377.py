# 빵 (25377번)
import sys
input = sys.stdin.readline

N = int(input().rstrip())
ans = sys.maxsize
for _ in range(N):
    A, B = map(int, input().rstrip().split())
    if A <= B:
        ans = min(ans, B)

print(-1 if ans == sys.maxsize else ans)

