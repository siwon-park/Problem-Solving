import sys

input = sys.stdin.readline

# Virus (13775번)
alpha ="abcdefghijklmnopqrstuvwxyz"
K = int(input().rstrip())
S = input().rstrip()
ans = ""
for s in S:
    if s not in alpha:
        ans += s
    else:
        idx = ord(s) - 97
        ans += alpha[(idx + 26 - K) % 26]
        K = K % 25 + 1

print(ans)

