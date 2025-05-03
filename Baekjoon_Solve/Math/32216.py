import sys

input = sys.stdin.readline

# 찬물 샤워 (32216번)
n, k, t = map(int, input().rstrip().split())
d = list(map(int, input().rstrip().split()))
ans = 0
for i in range(n):
    if t > k:
        t += d[i] - abs(t - k)
    elif t < k:
        t += d[i] + abs(t - k)
    elif t == k:
        t += d[i]
    ans += t - k

print(ans)
