import sys

input = sys.stdin.readline

# CPDU (33689번)
N = int(input().rstrip())
ans = 0
for i in range(N):
    s = input().rstrip()
    if s[0] == "C":
        ans += 1

print(ans)

