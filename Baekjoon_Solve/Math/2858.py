# 기숙사 바닥 (2858번)
import sys
input = sys.stdin.readline

R, B = map(int, input().rstrip().split())
_sum = R + B

for i in range(1, _sum + 1):
    if _sum % i == 0 and (_sum // i) * i == _sum:
        L = max(i, _sum // i)
        W = min(i, _sum // i)
        if 2 * L + 2 * W - 4 == R:
            print(L, W)
            break

