import sys

input = sys.stdin.readline

# Win Streak (34302번)
N = int(input().rstrip())
streak = 0
ans = 0
for i in range(N):
    s, t = map(int, input().rstrip().split())
    if s > t:
        streak += 1
        ans = max(ans, streak)
    else:
        streak = 0

print(ans)

