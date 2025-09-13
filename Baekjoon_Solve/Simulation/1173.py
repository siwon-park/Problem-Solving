import sys

input = sys.stdin.readline

# 운동 (1173번)
N, m, M, T, R = map(int, input().rstrip().split())

time = 0
n = 0
x = m
last_x = x
while n < N:
    if x + T <= M:
        x += T
        n += 1
    else:
        x = max(m, x - R)
    if last_x == x:
        time = -1
        break
    last_x = x
    time += 1

print(time)

