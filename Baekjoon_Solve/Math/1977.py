# 완전제곱수 (1977번)
import sys
input = sys.stdin.readline

M = int(input().rstrip())
N = int(input().rstrip())
_sum = 0
_min = 10001
for i in range(M, N + 1):
    num = int(i ** (1 / 2))
    if num * num == i:
        _sum += i
        _min = min(_min, i)

if _sum == 0:
    print(-1)
else:
    print(_sum)
    print(_min)

