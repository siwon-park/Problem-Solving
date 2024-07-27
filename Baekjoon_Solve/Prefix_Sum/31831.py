# 과민성 대장 증후군 (31831번)
import sys
input = sys.stdin.readline

n, m = map(int, input().rstrip().split())
A = [0] + list(map(int, input().rstrip().split()))
ans = 0
for i in range(1, n + 1):
    A[i] += A[i - 1]
    A[i] = max(A[i], 0)

for i in range(1, n + 1):
    if A[i] >= m:
        ans += 1

print(ans)

