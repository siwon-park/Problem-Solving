# 수박 게임 (31868번)
import sys
input = sys.stdin.readline

N, K = map(int, input().rstrip().split())
n = 1
while n < N:
    K //= 2
    n += 1

print(K)

