import sys

input = sys.stdin.readline

# 세금 (20492번)
N = int(input().rstrip())
print(int(N * 0.78), int(N * 0.8 )+ int(N * 0.2 * 0.78))

