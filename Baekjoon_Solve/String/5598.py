import sys
input = sys.stdin.readline

# 카이사르 암호 (5598번)
alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
S = input().rstrip()
ans = ""
for w in S:
    idx = ord(w) - 65
    ans += alpha[(idx + 23) % 26]

print(ans)

