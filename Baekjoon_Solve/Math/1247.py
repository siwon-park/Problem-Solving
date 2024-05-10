# 부호 (1247번)
import sys
input = sys.stdin.readline

for i in range(3):
    _sum = 0
    N = int(input().rstrip())
    for _ in range(N):
        _sum += int(input().rstrip())
    if _sum == 0:
        print(0)
    elif _sum < 0:
        print("-")
    else:
        print("+")

