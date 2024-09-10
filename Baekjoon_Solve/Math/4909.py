# Judging Olympia (4909번)
import sys
input = sys.stdin.readline

while True:
    a1, a2, a3, a4, a5, a6 = map(int, input().rstrip().split())
    if a1 == 0 and a2 == 0 and a3 == 0 and a4 == 0 and a5 == 0 and a6 ==0:
        break
    _max = max(a1, a2, a3, a4, a5, a6)
    _min = min(a1, a2, a3, a4, a5, a6)
    _sum = a1 + a2 + a3 + a4 + a5 + a6 - _max - _min
    if _sum % 4 == 0:
        print(int(_sum / 4))
    else:
        print(_sum / 4)

