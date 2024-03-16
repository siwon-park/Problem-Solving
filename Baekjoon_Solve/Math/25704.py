# 출석 이벤트 (25704번)
import sys
input = sys.stdin.readline

N = int(input().rstrip())
P = int(input().rstrip())
if N >= 20:
    print(max(0, min(P - 2000, P - P // 4)))
elif N >= 15:
    print(max(0, min(P - 2000, P - P // 10)))
elif N >= 10:
    print(max(0, min(P - 500, P - P // 10)))
elif N >= 5:
    print(max(0, P - 500))
else:
    print(P)

