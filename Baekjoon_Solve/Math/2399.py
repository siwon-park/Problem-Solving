import sys

input = sys.stdin.readline

# 거리의 합 (2399번)
n = int(input().rstrip())
lst = list(map(int, input().rstrip().split()))
ans = 0
lst.sort()
for i in range(n):
    ans += lst[i] * (2 * i - 2 * (n - i - 1))

print(ans)

