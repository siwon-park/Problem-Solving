import sys

input = sys.stdin.readline

# 빙고 막기 (32246번)
N = int(input().rstrip())
if N == 2:
    print(3)
else:
    print(N)

