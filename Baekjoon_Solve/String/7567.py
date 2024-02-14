# 그릇 (7567번)
import sys
input = sys.stdin.readline

line = input().rstrip()
last = ""
n = len(line)
ans = 0
for i in range(n):
    if last != line[i]:
        ans += 10
    else:
        ans += 5
    last = line[i]

print(ans)

