import sys
input = sys.stdin.readline

# Max (9913번)
n = int(input().rstrip())
lst = [0 for i in range(1001)]
ans = 0
for i in range(n):
    num = int(input().rstrip())
    lst[num] += 1
    ans = max(ans, lst[num])

print(ans)

