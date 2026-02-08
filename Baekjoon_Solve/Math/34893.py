import sys

input = sys.stdin.readline

# 억지부리기 (34893번)
U, O, S = map(int, input().rstrip().split())
t = max(0, min((U - S) // 3, U // 2))
print(min(O, U - 2 * t, S + t))
