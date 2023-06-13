# 핸드폰 요금 (1267번)
import sys
input = sys.stdin.readline

N = int(input().rstrip())
fee = list(map(int, input().rstrip().split()))

Y = 0
M = 0
for i in range(N):
    cur = fee[i]
    Y += ((cur // 30) + 1) * 10
    M += ((cur // 60) + 1) * 15

if Y > M:
    print("M " + str(M))
elif Y < M:
    print("Y " + str(Y))
elif Y == M:
    print("Y M " + str(Y))