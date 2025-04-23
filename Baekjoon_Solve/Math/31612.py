import sys

input = sys.stdin.readline

# 画数数え (Stroke Count) (31612번)
n = int(input().rstrip())
s = input().rstrip()
cnt = 0
for i in range(n):
    if s[i] == 'o':
        cnt += 1
    else:
        cnt += 2

print(cnt)

