# 준영이의 등급 (30008번)
import sys
input = sys.stdin.readline

N, K = map(int, input().rstrip().split())
G = list(map(int, input().rstrip().split()))
D = [0 for _ in range(K)]
for i in range(K):
    p = (G[i] * 100) // N
    if 0 <= p <= 4:
        D[i] = 1
    elif p <= 11:
        D[i] = 2
    elif p <= 23:
        D[i] = 3
    elif p <= 40:
        D[i] = 4
    elif p <= 60:
        D[i] = 5
    elif p <= 77:
        D[i] = 6
    elif p <= 89:
        D[i] = 7
    elif p <= 96:
        D[i] = 8
    elif p <= 100:
        D[i] = 9

print(*D)
