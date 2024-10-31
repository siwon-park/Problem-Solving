# 강당 대관 (31994번)
import sys
input = sys.stdin.readline

ans = ""
max_c = 0
for i in range(7):
    a, b = input().rstrip().split()
    c = int(b)
    if max_c < c:
        max_c = c
        ans = a

print(ans)

