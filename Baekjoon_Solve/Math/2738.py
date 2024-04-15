# 행렬 덧셈 (2738번)
import sys
input = sys.stdin.readline

N, M = map(int, input().rstrip().split())
A, B = [], []
for i in range(N):
    A.append(list(map(int, input().rstrip().split())))

for i in range(N):
    B.append(list(map(int, input().rstrip().split())))

for i in range(N):
    for j in range(M):
        A[i][j] += B[i][j]

for i in range(N):
    print(*A[i])

