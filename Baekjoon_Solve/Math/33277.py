import sys
input = sys.stdin.readline

# 국방시계 (33277번)
N, M = map(int, input().rstrip().split())
total = (M * 24 * 3600) // N
HH = total // 3600
MM = (total % 3600) // 60
if HH < 10:
    HH = "0" + str(HH)
if MM < 10:
    MM = "0" + str(MM)
print(f'{HH}:{MM}')

