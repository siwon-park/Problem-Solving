# Decoder (5365번)
import sys
input = sys.stdin.readline

n = int(input().rstrip())
lst = input().rstrip().split()
ans = ""
m = 1  # 마지막 단어의 길이
for i in range(n):
    cur = len(lst[i])  # 현재 단어의 길이
    if m > cur:
        ans += " "
    else:
        ans += lst[i][m - 1]
    m = cur

print(ans)

