import sys

input = sys.stdin.readline

# CASIO (15963번)
N, M = input().rstrip().split()
if N == M:
    print(1)
else:
    print(0)

