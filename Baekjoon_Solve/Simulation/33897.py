import sys

input = sys.stdin.readline

# 헤키레키잇센 (33897번)
n = int(input().rstrip())
lst = list(map(int, input().rstrip().split()))
last = 0
cnt = 1
max_streak = 0
streak = 0
for i in range(n):
    if lst[i] >= last:
        streak += 1
    else:
        streak = 1
        cnt += 1
    last = lst[i]
    max_streak = max(max_streak, streak)

print(cnt, max_streak)

