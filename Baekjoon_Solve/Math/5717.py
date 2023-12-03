# 상근이의 친구들 (5717번)
import sys
input = sys.stdin.readline

while True:
    M, F = map(int, input().rstrip().split())
    if M == 0 and F == 0:
        break
    print(M + F)
