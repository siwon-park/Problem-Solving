import sys

input = sys.stdin.readline

# SciComLove (2025) (33810번)
scilove = "SciComLove"
S = input().rstrip()
ans = 0
for i in range(10):
    if scilove[i] != S[i]:
        ans += 1

print(ans)

