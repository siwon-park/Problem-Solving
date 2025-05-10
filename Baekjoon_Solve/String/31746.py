import sys

input = sys.stdin.readline

# SciComLove (2024) (31746번)
N = int(input().rstrip())
S = "SciComLove"

if N % 2:
    print(S[::-1])
else:
    print(S)

