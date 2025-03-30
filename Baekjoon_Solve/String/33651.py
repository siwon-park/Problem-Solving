import sys

input = sys.stdin.readline

# Vandalism (33651)
S = input().rstrip()
org = "UAPC"
ans = ""
idx = 0
for s in org:
    if s not in S:
        ans += s

print(ans)

