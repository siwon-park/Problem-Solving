# 코인의 신 건모 (32866번)
import sys
input = sys.stdin.readline

N = int(input().rstrip())
X = int(input().rstrip())
rate = 1 - (X / 100)
print(f'{((N / (N * rate)) - 1) * 100:.6f}')
