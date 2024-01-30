# 약수 구하기 (2501번)
import sys
input = sys.stdin.readline

N, K = map(int, input().rstrip().split())
k = 0
ans = 0
for i in range(1, N + 1):
    if N % i == 0:
        k += 1
        if k == K:
            ans = i
            break

print(ans)

