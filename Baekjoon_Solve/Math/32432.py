import sys

input = sys.stdin.readline

# Attention to the Meeting (32432번)
N = int(input().rstrip())
K = int(input().rstrip())
breaks = N - 1
limit = K - breaks
print(limit // N)

