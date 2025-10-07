# Number Reduction (34437번)
import sys
input = sys.stdin.readline

N = int(input().rstrip())
cnt = 0
while N > 1:
    if N % 2:
        N += 2 * N + 1
        cnt += 1
    else:
        N = N >> 1
        cnt += 1

print(cnt)

