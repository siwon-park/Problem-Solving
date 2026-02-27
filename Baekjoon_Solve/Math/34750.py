import sys

input = sys.stdin.readline

# 추석은 언제나 좋아 (34750번)
N = int(input().rstrip())
give = 0
left = 0
if N >= 1_000_000:
    give = N * 0.2
elif N >= 500_000:
    give = N * 0.15
elif N >= 100_000:
    give = N * 0.1
else:
    give = N * 0.05

give = int(give)
print(give, N - give)
