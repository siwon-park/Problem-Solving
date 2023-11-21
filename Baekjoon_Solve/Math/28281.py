# 선물 (28281번)
import sys
input = sys.stdin.readline

N, X = map(int, input().rstrip().split())
A = list(map(int, input().rstrip().split()))
_min = 2002
for i in range(N - 1):
    _min = min(_min, A[i] + A[i + 1])

print(_min * X)
