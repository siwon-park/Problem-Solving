# 알파벳 점수 계산기 (34553번)
import sys
input = sys.stdin.readline

S = input().rstrip()
ans = 1
m = len(S)
last = ord(S[0])
cur = 1
for i in range(1, m):
    if last < ord(S[i]):
        cur += 1
        ans += cur
    else:
        cur = 1
        ans += cur
    last = ord(S[i])

print(ans)

