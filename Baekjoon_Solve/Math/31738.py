import sys

input = sys.stdin.readline

# 매우 어려운 문제 (31738번)
n, m = map(int, input().rstrip().split())
if n >= m:
    print(0)
else:
    ret = 1
    for i in range(n, 0, -1):
        ret *= i
        ret %= m
    print(ret % m)

