import sys

input = sys.stdin.readline

# 출제자가 몇 명 (34722번)
n = int(input().rstrip())
ans = 0
for i in range(n):
    s, c, a, r = map(int, input().rstrip().split())
    if s >= 1000 or c >= 1600 or a >= 1500 or (1 <= r <= 30):
        ans += 1

print(ans)

