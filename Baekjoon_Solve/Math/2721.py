# 삼각수의 합  (2721번)
import sys
input = sys.stdin.readline

T = [0 for _ in range(302)]
W = [0 for _ in range(302)]
T[1] = 1
W[1] = 1
for i in range(2, 302):
    T[i] = T[i - 1] + i

for i in range(1, 301):
    W[i] = W[i - 1] + (T[i + 1]) * i

N = int(input().rstrip())
for _ in range(N):
    print(W[int(input().rstrip())])

