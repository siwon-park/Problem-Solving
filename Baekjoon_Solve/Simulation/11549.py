# Identifying tea (11549번)
import sys
input = sys.stdin.readline

T = int(input().rstrip())
lst = list(map(int, input().rstrip().split()))
ans = 0
for i in range(5):
    ans += 1 if lst[i] == T else 0

print(ans)

