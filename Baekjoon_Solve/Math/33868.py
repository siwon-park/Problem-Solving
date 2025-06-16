import sys

input = sys.stdin.readline

# 스티커 나눠주기 (33868번)
N = int(input().rstrip())
_min, _max = int(1e9), -int(1e9)
for i in range(N):
    t, b = map(int, input().rstrip().split())
    _max = max(_max, t)
    _min = min(_min, b)

print((_min * _max) % 7 + 1)

