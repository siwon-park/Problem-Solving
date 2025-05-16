import sys

input = sys.stdin.readline

# (33845번)
S = input().rstrip()
T = input().rstrip()

ans = ""
for w in T:
    if w not in S:
       ans += w

print(ans)

