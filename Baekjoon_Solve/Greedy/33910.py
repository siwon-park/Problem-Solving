import sys

input = sys.stdin.readline

# 합의 최소 (33910번)
n = int(input().rstrip())
A = list(map(int, input().rstrip().split()))

_sum = A[n - 1]
for i in range(n - 2, -1, -1):
    if A[i + 1] < A[i]:
        A[i] = A[i + 1]
    _sum += A[i]

print(_sum)

