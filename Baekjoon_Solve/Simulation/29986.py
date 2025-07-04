import sys

input = sys.stdin.readline

# 29986번
n, h = map(int, input().rstrip().split())
ans = 0
lst = list(map(int, input().rstrip().split()))
for num in lst:
    if h >= num:
        ans += 1

print(ans)

