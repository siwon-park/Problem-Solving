import sys

input = sys.stdin.readline

# 몇개고? (27294번)
t, s = map(int, input().rstrip().split())
if 12 <= t <= 16 and s == 0:
    print(320)
else:
    print(280)

