import sys

input = sys.stdin.readline

# 지속 (11648번)
N = input().rstrip()
ans = 0
while len(N) > 1:
    lst = list(N)
    tmp = 1
    for num in lst:
        tmp *= int(num)
    N = str(tmp)
    ans += 1

print(ans)

