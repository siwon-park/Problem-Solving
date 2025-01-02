# 수열이에요? (32752번)
import sys
input = sys.stdin.readline

N, L, R = map(int, input().rstrip().split())
A = list(map(int, input().rstrip().split()))
A = A[:L - 1] + sorted(A[L - 1:R]) + A[R:]

ans = 1
for i in range(1, N):
    if A[i - 1] > A[i]:
        ans = 0

print(ans)

