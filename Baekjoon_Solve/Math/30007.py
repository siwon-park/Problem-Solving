# 라면 공식 (30007번)
import sys
input = sys.stdin.readline

N = int(input().rstrip())  # 테스트 케이스의 수
for _ in range(N):
    A, B, X = map(int, input().rstrip().split())
    W = A * (X - 1) + B
    print(W)
