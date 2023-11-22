# 탁구 경기 (27918번)
import sys
input = sys.stdin.readline

N = int(input().rstrip())
d, p = 0, 0
for _ in range(N):
    ret = input().rstrip()
    if abs(d - p) >= 2:
        continue
    if ret == "P":
        p += 1
    elif ret == "D":
        d += 1

print(f'{d}:{p}')