import sys, math

input = sys.stdin.readline

# Hezardastan’s Annual Report (33179번)
n = int(input().rstrip())
lst = list(map(int, input().rstrip().split()))

ans = 0
for i in range(n):
    ans += math.ceil(lst[i] / 2)

print(ans)
