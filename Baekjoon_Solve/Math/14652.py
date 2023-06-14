# 나는 행복합니다~ (14652번)
import sys
input = sys.stdin.readline

N, M, K = map(int, input().rstrip().split())
print(K // M, K % M)