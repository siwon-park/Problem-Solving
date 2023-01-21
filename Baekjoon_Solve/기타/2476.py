# 주사위 게임 (2476번)
"""

"""
import sys
input = sys.stdin.readline


N = int(input().rstrip())
ans = 0
for _ in range(N):
    a, b, c = map(int, input().rstrip().split())
    ret = 0
    if a == b == c:
        ret = 10000 + 1000 * a
    elif a == b:
        ret = 1000 + 100 * a
    elif b == c:
        ret = 1000 + 100 * b
    elif a == c:
        ret = 1000 + 100 * c
    else:
        ret = 100 * max(a, b, c)
    ans = max(ret, ans)

print(ans)
