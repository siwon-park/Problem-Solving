# 지폐 세기 (30031번)
import sys
input = sys.stdin.readline

N = int(input().rstrip())
ans = 0
for _ in range(N):
    r, c = map(int, input().rstrip().split())
    if r == 136:
        ans += 1000
    elif r == 142:
        ans += 5000
    elif r == 148:
        ans += 10000
    elif r == 154:
        ans += 50000

print(ans)
